### git
git tag -a 2.4.1 -m "v2.4.1"

### jitpack
https://jitpack.io/#zhuweideng/mixpush/2.4.4


### gradle offical setting
https://docs.gradle.org/current/userguide/signing_plugin.html
gradle 签名用RSA签名
（4）RSA（仅用于签名）

> brew install gpg

key 列表  
> gpg -K 

导出key
> gpg --keyring secring.gpg --export-secret-keys > ~/.gnupg/secring.gpg

gpg --gen-key
gpg --list-keys
// gpg --export-secret-keys --armor > private.key
// gpg --export --armor > public.key


### gradle发布jar包到maven仓库遇到的问题解决
https://blog.csdn.net/ThomasChant/article/details/118940537

### gradle 
https://blog.csdn.net/health7788/article/details/132815303
https://www.jb51.net/article/281705.htm