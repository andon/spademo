Dynamic Components using SPA Concepts
========

This project is a demonstration of how you can build dynamic components using Single-Page-Application concepts in Adobe Experience Manager (CQ5).

Presentation: http://www.slideshare.net/netceteragroup/dynamic-components-using-singlepageapplication-concepts-in-aemcq-39532610

Setup
-----

This project uses the NEBA framework (http://neba.io/). Make sure that you have installed NEBA onto your CQ instance, before you start to play with this project.

Goto http://neba.io/download.html, download the AEM package for NEBA 3.2.0 and install it with Package Manager.

After this you can use the following guide to install the demo project.

Also, check https://github.com/andon/spademo/wiki/Project-Setup-with-NEBA

Building
--------

This project uses Maven for building. Common commands:

From the root directory, run ``mvn -PautoInstallPackage clean install`` to build the bundle and content package and install to a CQ instance.

From the bundle directory, run ``mvn -PautoInstallBundle clean install`` to build *just* the bundle and install to a CQ instance.

Using with VLT
--------------

To use vlt with this project, first build and install the package to your local CQ instance as described above. Then cd to `content/src/main/content/jcr_root` and run

    vlt --credentials admin:admin checkout -f ../META-INF/vault/filter.xml --force http://localhost:4502/crx

Once the working copy is created, you can use the normal ``vlt up`` and ``vlt ci`` commands.

Specifying CRX Host/Port
------------------------

The CRX host and port can be specified on the command line with:
mvn -Dcrx.host=otherhost -Dcrx.port=5502 <goals>


