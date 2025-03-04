set -o errtrace
set -o nounset
set -o pipefail
set -eu

# buck-out/v2/gen/toolchains/904931f735703749/internal/__compile_kotlin__/compile_kotlin --kotlinc_output buck-out/v2/gen/root/904931f735703749/java/io/ajarara/kotdep/__kotdep__/kotlinc_classes_output --zip_scrubber '' --kotlinc_cmd_file buck-out/v2/gen/root/904931f735703749/java/io/ajarara/kotdep/__kotdep__/kotlinc_cmd

while [[ $# -gt 0 ]]; do
    case $1 in
        --kotlinc_output)
            KOTLINC_OUTPUT="$2"
            shift 2
            ;;
        --zip_scrubber)
            ZIP_SCRUBBER="$2"
            shift 2
            ;;
        --kotlinc_cmd_file)
            KOTLINC_CMD_FILE="$2"
            shift 2
            ;;
        # --skip_javac_run)
        #     SKIP_JAVAC_RUN=1
        #     shift 1
        #     ;;
        *)
            echo "unknown switch $1"
            exit 1
            ;;
    esac
done

env

mkdir -p $KOTLINC_OUTPUT
exit 1
# `cat $KOTLINC_CMD_FILE`



