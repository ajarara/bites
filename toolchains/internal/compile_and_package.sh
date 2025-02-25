set -o errtrace
set -o nounset
set -o pipefail
set -eu

while [[ $# -gt 0 ]]; do
    case $1 in
        --jar_builder_tool)
            JAR_BUILDER_TOOL="$2"
            shift 2
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
        --javac_classpath_file)
            JAVAC_CLASSPATH_FILE="$2"
            shift 2
            ;;
        --skip_javac_run)
            SKIP_JAVAC_RUN=1
            shift 1
            ;;
        --additional_compiled_srcs)
            ADDITIONAL_COMPILED_SRCS="$2"
            shift 2
            ;;
        *)
            echo "unknown switch $1"
            exit 1
            ;;
    esac
done

[[ -n JAR_BUILDER_TOOL ]] && JAR_BUILDER_TOOL="jar"

# solo dependencies don't have anything on the path, so the argument might be omitted altogether
[[ -v JAVAC_CLASSPATH_FILE ]] || JAVAC_CLASSPATH_FILE=""

if [[ ! -v SKIP_JAVAC_RUN ]]; then
    $JAVAC_TOOL @$JAVAC_ARGS_FILE -d $TMPDIR -cp @$JAVAC_CLASSPATH_FILE
fi

$JAR_BUILDER_TOOL --create --file $OUTPUT -C $TMPDIR/ .

if [[ -v GENERATED_SOURCES_DIR ]]; then
   # generated sources? ignore for now.
    mkdir -p $GENERATED_SOURCES_DIR
fi
   
