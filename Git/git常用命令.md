# 一、基础操作

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
  
  
# 二、建立本地git仓库
  
* 1、cd到你的项目目录
  ```
  C:\Users\sunny>D:
  D:\>cd studyCodes\git\test
  ```
* 2、然后,输入git命令`git init`
  ```
  D:\studyCodes\git\test>git init
  Initialized empty Git repository in D:/studyCodes/git/test/.git/
  ```
  * 创建了一个空的本地仓库。

* 3、将项目的所有文件添加到缓存中`git add .`
  ```
  D:\studyCodes\git\test>git add .

  D:\studyCodes\git\test>
  ```
  * `git add .` (注意,后面有个点)表示添加目录下所有文件到缓存库,如果只添加某个文件,只需把 `.` 换成你要添加的文件名即可。 

* 4、将缓存中的文件Commit到git库`git commit -m "添加你的注释,一般是一些更改信息"`
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
