set -o errtrace
set -o nounset
set -o pipefail
set -eu

ARCHIVE=$1
OUTPUT=$2

# so far this is binary so we might as well just copy and paste
# things. Different abi generation modes exist (namely, source, where
# you get the ABI before you compile), but /shrug
cp $ARCHIVE $OUTPUT
