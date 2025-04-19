#!/usr/bin/env /bin/sh

set -o errtrace
set -o nounset
set -o pipefail
set -eu

function build () {
    case "$1" in
        *) echo "Unknown example: $1"; exit 1;;
    esac
}

function test () {
    case "$1" in
        *) echo "Unknown example: $1"; exit 1;;
    esac
}

case "$1" in
    "test" | "build") $@;;
    *) echo "Unknown subcommand $1"; exit 1;;
esac
