LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

include kodi-git.inc

inherit pkgconfig gettext

S = "${WORKDIR}/git/tools/depends/native/libsquish-native/"

export PREFIX="${D}${prefix}"
export NATIVEPREFIX="${D}${prefix}"
export PLATFORM="${PACKAGE_ARCH}"

do_compile (){
    oe_runmake $PLATFORM/libsquish.a
}

do_install (){
    mkdir -p ${D}${prefix}/include
    mkdir -p ${D}${prefix}/lib/pkgconfig
    oe_runmake
}

BBCLASSEXTEND = "native nativesdk"
