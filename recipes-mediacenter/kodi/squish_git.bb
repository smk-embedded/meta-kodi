LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

include kodi-git.inc

inherit pkgconfig gettext

S = "${WORKDIR}/git/tools/depends/native/libsquish-native/src"

export PREFIX="${D}${prefix}"

do_configure (){
    sed "s|@PREFIX@|${PREFIX}|" config.in > config
    sed -i "s|@PREFIX@|${prefix}|" squish.pc.in
}
do_compile (){
    oe_runmake libsquish.a
}

do_install (){
    mkdir -p ${D}${prefix}/include
    mkdir -p ${D}${prefix}/lib/pkgconfig
    oe_runmake install
}

BBCLASSEXTEND = "native nativesdk"
