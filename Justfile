set shell := ["nu", "-c"]

help:
    @just --list

download_felix:
    rm -rf org.apache.felix.main.distribution-7.0.5.zip
    rm -rf felix
    http get https://www.apache.org/dyn/closer.lua/felix/org.apache.felix.main.distribution-7.0.5.zip?action=download \
      | save org.apache.felix.main.distribution-7.0.5.zip
    jar --extract --file org.apache.felix.main.distribution-7.0.5.zip
    mv felix-framework-7.0.5 felix
    rm -rf org.apache.felix.main.distribution-7.0.5.zip

download_libs:
    rm -rf libs
    mkdir libs
    http get https://repo1.maven.org/maven2/org/osgi/org.osgi.framework/1.10.0/org.osgi.framework-1.10.0.jar \
        | save libs/org.osgi.framework-1.10.0.jar
    cp libs/org.osgi.framework-1.10.0.jar felix/bundle/org.osgi.framework-1.10.0.jar

run_felix:
    rm -rf felix/felix-cache
    cd felix; java -jar ./bin/felix.jar

compile_number_converter:
    rm -rf build/number-converter/classes
    javac \
        -d build/number-converter/classes \
        --class-path libs/org.osgi.framework-1.10.0.jar \
        ...(ls ./number-converter/src/**/*.java | get "name")

    rm -rf build/number-converter/number-converter.jar
    jar --create \
        --file build/number-converter/number-converter.jar \
        --manifest=number-converter/MANIFEST.MF \
        -C build/number-converter/classes .


    cp build/number-converter/number-converter.jar felix/bundle/number-converter.jar

compile_ui: compile_number_converter
    rm -rf build/ui/classes
    javac \
        -d build/ui/classes \
        --class-path "libs/org.osgi.framework-1.10.0.jar;build/number-converter/number-converter.jar" \
        ...(ls ./ui/src/**/*.java | get "name")

    rm -rf build/ui/ui.jar
    jar --create \
        --file build/ui/ui.jar \
        --manifest=ui/MANIFEST.MF \
        -C build/ui/classes .

    cp build/ui/ui.jar felix/bundle/ui.jar

clean_run: download_felix download_libs compile_number_converter compile_ui run_felix