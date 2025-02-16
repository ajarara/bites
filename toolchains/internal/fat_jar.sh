set -o errtrace
set -o nounset
set -o pipefail
set -eu

# --jar_builder_tool --zip_scrubber_tool --output buck-out/v2/gen/root/904931f735703749/__MyGreatApp__/MyGreatApp.jar --jars_file buck-out/v2/gen/root/904931f735703749/__MyGreatApp__/jars_file --main_class io.ajarara.example.Example

while [[ $# -gt 0 ]]; do
    case $1 in
        --jar_builder_tool)
            # ignore it, unsure why it's passed
            shift 1
            ;;
        --zip_scrubber_tool)
            # ignoreeeee
            shift 1
            ;;
        '')
            # ignore this too, unsure why it's passed
            shift 1
            ;;
        --output)
            OUTPUT="$2"
            shift 2
            ;;
        --jars_file)
            JARS_FILE="$2"
            shift 2
            ;;
        --main_class)
            MAIN_CLASS="$2"
            shift 2
            ;;
        *)
            echo "unknown switch $1"
            exit 1
            ;;
    esac
done

# create manifest
MANIFEST_PATH="$TMPDIR/manifest"
cat >$MANIFEST_PATH <<EOF
Manifest-Version: 1.0
Class-Path: .
Main-Class: $MAIN_CLASS
EOF

PROJECT_ROOT="$(pwd)"

# unpack all jars in $JAR_FILE
CLASSES="$TMPDIR/classes/"
mkdir $CLASSES

echo $JARS_FILE
pushd $CLASSES
while IFS= read -r line || [[ -n "$line" ]]; do
    JAR="$PROJECT_ROOT/$line"
    echo "$JAR"
    jar -x -f "$JAR"
done < "$PROJECT_ROOT/$JARS_FILE"

popd


# repack into jar file
jar --create --file $OUTPUT --manifest=$MANIFEST_PATH -C $CLASSES .

env
echo "fat_jar"
echo $@
