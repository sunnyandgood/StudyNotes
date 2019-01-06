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
  ```
  D:\studyCodes\git\test>copy con A.txt
  第一次操作Hello world!
  ^Z
  已复制         1 个文件。

  D:\studyCodes\git\test>type A.txt
  第一次操作Hello world!

  D:\studyCodes\git\test>git add .

  D:\studyCodes\git\test>git commit -m "第一次提交"
  [master (root-commit) 4e7723a] 第一次提交
   1 file changed, 1 insertion(+)
   create mode 100644 A.txt

  D:\studyCodes\git\test>
  ```
  
  * 或者不添加注释 `git commit`,但是这样会进入vim(vi)编辑器
  
    ```
    # Please enter the commit message for your changes. Lines starting
    # with '#' will be ignored, and an empty message aborts the commit.
    #
    # On branch master
    # Changes to be committed:
    #       new file:   B.t
    #    
    
    
    D:/studyCodes/git/test/.git/COMMIT_EDITMSG [unix] (17:54 06/01/2019) 
    ```
    * 在这里可以输入更改信息,也可以不输入,然后 按住 `shift + :`  ,输入`wq` 即可保存信息并退出vim编辑器;
  
    ```
    D:\studyCodes\git\test>copy con B.t
    hahaha
    ^Z
    已复制         1 个文件。

    D:\studyCodes\git\test>git add B.t

    D:\studyCodes\git\test>git commit
    Aborting commit due to empty commit message.

    D:\studyCodes\git\test>
    ```
  
# 三、建立远程连接，用代码托管平台存放代码
* 1、在一些代码托管平台创建项目,例如github或者开源中国社区,这里以github社区为例;创建项目后,会生成一个HTTPS链接,如下:`https://github.com/sunnyandgood/test.git`
* 2、将本地的库链接到远，终端输入: `git remote add origin HTTPS链接`
  ```
  D:\studyCodes\git\test>git remote add origin https://github.com/sunnyandgood/test.git

  D:\studyCodes\git\test>
  ```
* 3、上传代码到远程库,上传之前最好先Pull一下,再执行命令: `git pull origin master`
  
  ```
  $ git pull origin master
  warning: no common commits
  remote: Counting objects: 3, done.
  remote: Total 3 (delta 0), reused 0 (delta 0)
  Unpacking objects: 100% (3/3), done.
  From https://github.com/sunnyandgood/test
   * branch            master     -> FETCH_HEAD
   * [new branch]      master     -> origin/master
  Merge made by the 'recursive' strategy.
   README.md | 1 +
   1 file changed, 1 insertion(+)
   create mode 100644 README.md
  ```
  * 即pull成功。
* 4、接着执行:`git push origin master`

  * 完成后输出:
  ```
  $ git push origin master
  Enumerating objects: 3, done.
  Counting objects: 100% (3/3), done.
  Writing objects: 100% (3/3), 245 bytes | 245.00 KiB/s, done.
  Total 3 (delta 0), reused 0 (delta 0)
  To https://github.com/sunnyandgood/test.git
   * [new branch]      master -> master
  ```
  * 即将代码成功提交到远程库!!!
  
* 注：如果pull之后出现 “ refusing to merge unrelated histories ”这句，就证明你合并pull两个不同的项目

  * 出现的问题如何去解决fatal: refusing to merge unrelated histories

  * 我在Github新建一个仓库，写了License，然后把本地一个写了很久仓库上传。

  * 先pull，因为两个仓库不同，发现refusing to merge unrelated histories，无法pull

  * 因为他们是两个不同的项目，要把两个不同的项目合并，git需要添加一句代码，在git pull，这句代码是在git 2.9.2版本发生的，最新的版本需要添加--allow-unrelated-histories

  * 假如我们的源是origin，分支是master，那么我们 需要这样写git pull origin master --allow-unrelated-histories需要知道，我们的源可以是本地的路径
