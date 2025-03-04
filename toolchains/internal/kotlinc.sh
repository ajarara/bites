set -o errtrace
set -o nounset
set -o pipefail
set -eu

env
kotlinc
