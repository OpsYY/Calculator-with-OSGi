TR
----------------------------------------------------------------------
Uygulama Desilyon'a (10^33) kadar desteklemektedir.

Eksi sayılar girdi olarak yazılabilir veya çıktı olarak okunabilir.
Yazılım yanlışı söz konusu olduğunda uygulama verilen girdileri kontrol edip yazım yanlışı konusunda sizi uyaracak ve kodun devamını çalıştırmayacaktır.

Kullanıcı arayüzü için Swing kullanılmaktadır.

boolean değeri olan "locale" true olduğu durumlarda Türkçe, false olduğu durumlarda uygulama ingilizce olarak çalışmaktadır. Varsayılan dil Türkçedir. Arayüzde bulunan radiobuttonlar ile dil değişimi uygulamayı kapatmadan yapılabilmektedir.

Bundle yükleme ve çalıştırma için Apache Felix kullanılmıştır.

Yazıları sayıya ve sayıları yazıya çeviren, toplama çıkarma işlemlerini yapan "number-converter" servisi bulunmaktadır. Bu methodlar ise "UI" içerisinde kullanılmaktadır.

"Justfile.txt" içerisinde bulunan sınıflandırılmış CMD komutları şunlardır.
download_felix - Apache felix indirmek için kullanılmaktadır.
download_libs - osgi frameworkü indirmek için kullanılmaktadır.
run_felix Apache Felix'i başlatılmak için kullanılmaktadır.
compile_number_converter number converter classını jar dosyasına dönüştürmek için kullanılmaktadır.
compile_ui -  UI classını jar dosyasına dönüştürmek için kullanılmaktadır.
clean_run - projeyi temizleyip jar dosyalarını tekrardan oluşturup Apache Felix başlatılır.

Komutları sırası ile terminal'e yazmak yerine Just_Master adı verilen bir tool kullandım. Bu tool justfile.txt içerisinde sırasıyla yazılmış cmd komutlarını alır ve satır satır çalıştırır.
İndirmek için: "winget install --id Casey.Just --exact"
Örnek kullanım: "just clean_run"

EN
----------------------------------------------------------------------
The application supports up to Decillion (10^33).

Minus numbers can be written as input or read as output.
In case of a typo, the application will check the input and warn you about the typo and will not execute the rest of the code.

Swing is used for the user interface.

When the boolean value "locale" is true, the application runs in Turkish, when false, the application runs in English. The default language is Turkish. With the radiobuttons on the interface, language switching can be done without closing the application.

Apache Felix was used for bundle installation and execution.

As stated in the assignment, there is a "number-converter" service that converts text to numbers and numbers to text and performs addition and subtraction operations. These methods are used in the "UI".

Classified CMD commands found in "Justfile.txt" are as follows
download_felix - used to download Apache felix.
download_libs - used to download osgi framework.
run_felix is used to start Apache Felix.
compile_number_converter is used to convert number converter class to jar file.
compile_ui - is used to convert UI class to jar file.
clean_run - clean the project, rebuild the jar files and start Apache Felix.

Instead of typing the commands in the terminal, I used a tool called Just_Master which takes the cmd commands written in justfile.txt and runs them line by line.
To download: "winget install --id Casey.Just --exact"

