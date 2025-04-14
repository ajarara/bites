#!/usr/bin/env bash

# listen to file changes of source directories and issue rebuilds of any subprojects.
# maven keeps 
inotifywait -r -e create -e modify --exclude='(.#|cmake-)' .

