FILESEXTRAPATHS_prepend := "${THISDIR}/linux:"

SRC_URI_append = " file://lxc.cfg \
                   file://can.cfg \
           "
KERNEL_CONFIG_FRAGMENTS_append = " \
             ${WORKDIR}/lxc.cfg \
             ${WORKDIR}/can.cfg \
"
