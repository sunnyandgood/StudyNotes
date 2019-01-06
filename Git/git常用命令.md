### 1、配置用户名和邮箱:
  ```
  $ git config --global user.name "Your Name"  
  $ git config --global user.email "email@example.com"  
  ```
* 使用 --global 修饰后设置的全局的用户,如果设置单个项目的用户,可cd到项目根目录下,执行如下命令:
  ```
  $ git config user.name "Your Name"  
  $ git config user.email "email@example.com"  
  ```

### 2、git --version 
* 作用：查看当前git版本
* 示例：
  ```
  C:\Users\sunny>git --version
  git version 2.18.0.windows.1
  ```
### 3、git config --list
* 作用：查看当前用户信息以及其他的一些信息
* 示例
  ```git
  C:\Users\sunny>git config --list
  core.symlinks=false
  core.autocrlf=true
  core.fscache=true
  color.diff=auto
  color.status=auto
  color.branch=auto
  color.interactive=true
  help.format=html
  rebase.autosquash=true
  http.sslcainfo=D:/sotfWare/git/mingw64/ssl/certs/ca-bundle.crt
  http.sslbackend=openssl
  diff.astextplain.textconv=astextplain
  filter.lfs.clean=git-lfs clean -- %f
  filter.lfs.smudge=git-lfs smudge -- %f
  filter.lfs.process=git-lfs filter-process
  filter.lfs.required=true
  credential.helper=manager
  filter.lfs.clean=git-lfs clean -- %f
  filter.lfs.smudge=git-lfs smudge -- %f
  filter.lfs.process=git-lfs filter-process
  filter.lfs.required=true
  user.name=用户名
  user.email=邮箱名
  ```
