#!/usr/bin/env /bin/sh

set -o errtrace
set -o nounset
set -o pipefail
set -eu

function build () {
    case "$1" in
        "jvm") pushd jvm; mvn compile; popd;;
        *) echo "Unknown build target: $1"; exit 1;;
    esac
}

function test () {
    case "$1" in
        "jvm") pushd jvm; mvn test; popd;;
        *) echo "Unknown test target: $1"; exit 1;;
    esac
}

case "$1" in
    "test" | "build") $@;;
    "gradlew") pushd android; $@; popd;;
    *) echo "Unknown subcommand $1"; exit 1;;
esac
