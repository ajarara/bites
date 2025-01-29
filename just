#!/usr/bin/env /bin/sh

set -o errtrace
set -o nounset
set -o pipefail
set -eu

function build_app () {
   buck build :MyGreatApp
}

$@