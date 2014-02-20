#!/bin/bash
cd "~/Dropbox/UPV\ -\ Informática/4º\ año\ \(2013-2014\)/Applications\ in\ High\ End\ Computing\ \(APHC\)/Group\ Project/Lift---Drag-Workflow/hsqldb/data"
java -classpath ../lib/hsqldb.jar org.hsqldb.Server -database.0 file:$1 -dbname.0 $2
