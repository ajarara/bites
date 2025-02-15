# --jar_builder_tool --output buck-out/v2/gen/root/904931f735703749/java/io/ajarara/example/__example__/jar/example.jar --javac_tool javac --generated_sources_dir buck-out/v2/gen/root/904931f735703749/java/io/ajarara/example/__example__/generated_sources --javac_args_file buck-out/v2/gen/root/904931f735703749/java/io/ajarara/example/__example__/javac_args

while [[ $# -gt 0 ]]; do
    case $1 in
        --jar_builder_tool)
            # ignore it, unsure why it's passed
            shift 1
            ;;
        --output)
            OUTPUT="$2"
            shift 2
            ;;
        --javac_tool)
            JAVAC_TOOL="$2"
            shift 2
            ;;
        --generated_sources_dir)
            GENERATED_SOURCES_DIR="$2"
            shift 2
            ;;
        --javac_args_file)
            JAVAC_ARGS_FILE="$2"
            shift 2
            ;;
        *)
            shift 1
            ;;
    esac
done

$JAVAC_TOOL @$JAVAC_ARGS_FILE -d $TMPDIR

# pwd
# mkdir -p "$(dirname $OUTPUT)"
# echo "$(dirname $OUTPUT)"
# echo "ajarara $(pwd)/$OUTPUT"
# env
echo $JAVAC_ARGS_FILE

JAR_NAME="$(basename $OUTPUT)"

jar --create --file $JAR_NAME -C $TMPDIR/ .
mv $JAR_NAME $OUTPUT

# generated sources? ignore for now.
mkdir -p $GENERATED_SOURCES_DIR

echo "compile_and_package"

echo $@
