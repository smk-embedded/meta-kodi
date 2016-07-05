LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.GPL;md5=930e2a5f63425d8dd72dbd7391c43c46"

include kodi-git.inc

inherit gettext

do_configure () {
}

BUILD_CFLAGS += "-std=gnu99"
export PREFIX="${prefix}"

do_compile (){
    make -C ${S}/tools/depends/native/JsonSchemaBuilder/
}

do_install() {
    install -Dm 775 ${S}/tools/depends/native/JsonSchemaBuilder/bin/JsonSchemaBuilder ${D}${bindir}/JsonSchemaBuilder
}

BBCLASSEXTEND = "native nativesdk"
