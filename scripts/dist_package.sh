#!/bin/sh

ENV=$1

if [ -z "$ENV" ]; then
  echo "Usage: $0 [dev|prd]"
  exit 1
fi

echo "=== Build start. ==="
PLACE=`dirname $0`
FULLPATH=`(cd $PLACE; pwd)`
HERE=${FULLPATH}
cd ${HERE}
. ${HERE}/.env.sh

cd ${PROJECT_HOME}
cp -f ${PROJECT_HOME}/env/${ENV}/mongo.properties ${PROJECT_HOME}/env/mongo.properties
#gradle wrapper
#./gradlew installDist --scan
./gradlew installDist
if [ $? -ne 0 ]; then
  echo "=== Build failed. ==="
  exit 1
else
  echo "=== Build successfully done.  ==="
fi
cd build/install
DATE=`date +%Y%m%d%H%M%S-`
COMMIT=`git log --format="%H" -n 1`
BUILD_NO=${DATE}${COMMIT}
#echo $BUILD_NO
mv -f com.dignicate.p30a-ktor ${BUILD_NO}
if [ $? -ne 0 ]; then
  echo "=== Build aborted. ==="
  exit 1
fi
echo ${BUILD_NO} > ${HERE}/.build_no
cat ${HERE}/.build_no
exit 0