SRC_URI = "git://github.com/xbmc/xbmc.git;branch=${BRANCH}"
BRANCH = "Jarvis"
SRCREV = "4982009b56d184f8ce7890e947d0bd986e49828a"
#2baa51266144e970bdb04a959542298cd449d13f"
PV = "16+gitr${SRCPV}"

PATCHTOOL = "git"
S = "${WORKDIR}/git"
