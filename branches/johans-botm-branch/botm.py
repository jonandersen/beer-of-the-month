#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys, res, urllib2, random
from PyQt4 import QtGui, QtCore, uic
from PyQt4.QtCore import SIGNAL
from threading import Thread

class BeerOfTheMonth(QtCore.QObject):
    def __init__(self):
        QtGui.QMainWindow.__init__(self)
        self.ui = uic.loadUi('botm.ui')
        self.database = Database(self)
        self.settings = Settings()
        self.settingsGui = uic.loadUi('botm_settings.ui')
        self.parser = BeverageParser(self.database, self)
        self.connect(self.ui.exitButton, SIGNAL('clicked()'), QtGui.qApp, QtCore.SLOT('quit()'))
        self.connect(self.ui.actionRoll, SIGNAL('triggered()'), self.database.roll)
        self.connect(self.parser, SIGNAL('setProgressValue(int)'), self.ui.progressBar.setValue)
        self.connect(self.parser, SIGNAL('setProgressMaximum(int)'), self.ui.progressBar.setMaximum)
        self.connect(self.parser, SIGNAL('working(PyQt_PyObject)'), self.working)
        self.connect(self.parser, SIGNAL('appendLog(QString)'), self.ui.listWidget.addItem)
        self.connect(self.database, SIGNAL('rollResult(QString)'), self.ui.listWidget.addItem)
        self.connect(self.ui.actionSettings, SIGNAL('triggered()'), self.settingsGui.show)
        self.connect(self.settingsGui.okButton, SIGNAL('clicked()'), self.settingsGui.hide)
        self.connect(self.settingsGui.checkBoxStock, SIGNAL('toggled(bool)'), self.settings.setCheckIfInStock)
        self.connect(self.settingsGui.checkBoxBeer, SIGNAL('toggled(bool)'), self.settings.setBeer)
        self.connect(self.settingsGui.checkBoxRed, SIGNAL('toggled(bool)'), self.settings.setRed)
        self.connect(self.settingsGui.checkBoxWhite, SIGNAL('toggled(bool)'), self.settings.setWhite)
        self.connect(self.settingsGui.checkBoxSpark, SIGNAL('toggled(bool)'), self.settings.setSpark)
        self.connect(self.settingsGui.checkBoxSpirit, SIGNAL('toggled(bool)'), self.settings.setSpirit)
        self.connect(self.settingsGui.checkBoxSWine, SIGNAL('toggled(bool)'), self.settings.setStrongWine)
        self.connect(self.settingsGui.checkBoxNon, SIGNAL('toggled(bool)'), self.settings.setNonAlco)
        self.connect(self.settingsGui.checkBoxRose, SIGNAL('toggled(bool)'), self.settings.setRose)
        self.connect(self.settingsGui.checkBoxCider, SIGNAL('toggled(bool)'), self.settings.setCider)
        self.ui.show()
        self.parser.start()
        
    def working(self, isWorking):
        self.ui.progressBar.setEnabled(isWorking)
        self.ui.toolBar.setEnabled(not isWorking)      

class BeverageParser(QtCore.QThread):
    def __init__(self, database, parent=None):
        QtCore.QThread.__init__(self, parent)
        self.parent = parent
        self.database = database
        
    def log(self, message):
        self.emit(SIGNAL('appendLog(QString)'), message)

    def run(self):
        self.emit(SIGNAL('working(PyQt_PyObject)'), True)      
        self.log('Downloading and parsing database...')
        try:
            response = urllib2.urlopen('http://www.systembolaget.se/Applikationer/Knappar/Press/Alla+Artiklar?Format=Excel')
        except urllib2.URLError as e:
            self.log('Could not retrive database: ' + e.__str__())
        else:
            div = 200
            progMax = int(response.info().getheader('Content-Length').strip()) / (111*div)
            i = 0
            self.emit(SIGNAL('setProgressMaximum(int)'), progMax)
            while 1:
                line = response.readline()
                if not line:
                    break
                i += 1
                if not i%div and i/div <= progMax:
                    self.emit(SIGNAL('setProgressValue(int)'), i/div)
                line = unicode(line.strip('\r\n'), 'iso8859-1').split('\t')
                if line[0].isdigit():
                    if line[7] != '' and line[7] != u'PRESENTARTIKLAR':
                        bev = Beverage(line[0], line[1], line[3], line[4], line[7], line[13].strip('%'))
                        self.database.beverages.append(bev)                
                elif line[0] == 'Skapad Tid:':
                    self.database.createDate = line[-1]
                    self.log('Database was created: ' + self.database.createDate)
            self.log('Done!')
        finally:
            self.emit(SIGNAL('working(PyQt_PyObject)'), False)
            
class Database(QtCore.QObject):
    def __init__(self, parent=None):
        QtCore.QObject.__init__(self)
        self.createDate = ''
        self.beverages = []
        self.parent = parent
        
    def getBevs(self, type):
        return [bev for bev in self.beverages if bev.type in type]
        
    def roll(self):
        l = self.getBevs(self.parent.settings.getWanted())
        if not len(l):
            self.emit(SIGNAL('rollResult(QString)'), 'No beverages to choose between')
            return
        bev = random.choice(l)
        self.emit(SIGNAL('rollResult(QString)'), bev.__str__())
        

class Settings(QtCore.QObject):
    def __init__(self):
        self.types = [u'ÖL',]
        self.checkIfInStock = False

    def getWanted(self):
        return self.types
        
    def getCheckIfInStock(self):
        return self.checkIfInStock
        
    def setCheckIfInStock(self, value):
        self.checkIfInStock = value
    
    def setType(self, type, set=False):
        if set:
            if not type in self.types:
                self.types.append(type)
        else:
            if type in self.types:
                self.types.remove(type)
    
    def setBeer(self, set):
        self.setType(u'ÖL', set)
        
    def setCider(self, set):
        self.setType(u'CIDER OCH BLANDDRYCKER', set)

    def setSpirit(self, set):
        self.setType(u'SPRIT', set)

    def setRed(self, set):
        self.setType(u'RÖDA VINER', set)

    def setWhite(self, set):
        self.setType(u'VITA VINER', set)

    def setSpark(self, set):
        self.setType(u'MOUSSERANDE VINER', set)

    def setNonAlco(self, set):
        self.setType(u'ALKOHOLFRITT', set)

    def setRose(self, set):
        self.setType(u'ROSÉVINER', set)

    def setStrongWine(self, set):
        self.setType(u'STARKVIN M.M.', set)

class Beverage():
    def __init__(self, number, name, price, volume, type, perc):
        self.number = number
        self.name = name
        self.price = price
        self.volume = volume
        self.type = type
        self.perc = perc

    def checkIfInStock(self):
        pass

    def __str__(self):
        return unicode(self.type + ': ' + self.name + ', ' + self.volume + 'ml, ' + self.price + 'kr, ' + self.perc + '%')

if __name__ == '__main__':
    app = QtGui.QApplication(sys.argv)
    window = BeerOfTheMonth()
    sys.exit(app.exec_())
