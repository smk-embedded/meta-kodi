PACKAGECONFIG = "pcre8 pcre16 pcre32"
EXTRA_OECONF += "\
    --enable-unicode-properties \
"

#    --with-link-size=4 \
#EXTRA_OECONF_remove = "--with-link-size=2"
#BUILD_CFLAGS_remove = "-DLINK_SIZE=2"
#BUILD_CFLAGS =+ "-DLINK_SIZE=4"
