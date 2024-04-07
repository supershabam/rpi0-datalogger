LICENSE = "CLOSED"

SRC_URI = "https://github.com/prometheus/prometheus/releases/download/v2.51.1/prometheus-2.51.1.linux-armv6.tar.gz \
           file://prometheus-server.service \
           "
SRC_URI[sha256sum] = "3cf6cc353f7f45d82f4761f7b527507ba93fdaa4e13c08b92e47347b7061c46a"

FILES_${PN} += "${systemd_unitdir}/system/prometheus-server.service"

S = "${WORKDIR}/prometheus-2.51.1.linux-armv6"

inherit systemd

SYSTEMD_SERVICE:${PN} = "prometheus-server.service"
SYSTEMD_AUTO_ENABLE = "enable"

do_install () {
	install -d ${D}${sbindir}
	install -m 755 ${S}/prometheus ${D}${sbindir}

    install -d ${D}/${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/prometheus-server.service ${D}/${systemd_unitdir}/system
}