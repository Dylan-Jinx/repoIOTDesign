USE [master]
GO
/****** Object:  Database [User]    Script Date: 2020/7/18 18:47:17 ******/
CREATE DATABASE [User]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'User', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\User.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'User_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\User_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [User] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [User].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [User] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [User] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [User] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [User] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [User] SET ARITHABORT OFF 
GO
ALTER DATABASE [User] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [User] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [User] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [User] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [User] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [User] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [User] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [User] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [User] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [User] SET  DISABLE_BROKER 
GO
ALTER DATABASE [User] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [User] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [User] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [User] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [User] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [User] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [User] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [User] SET RECOVERY FULL 
GO
ALTER DATABASE [User] SET  MULTI_USER 
GO
ALTER DATABASE [User] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [User] SET DB_CHAINING OFF 
GO
ALTER DATABASE [User] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [User] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [User] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'User', N'ON'
GO
ALTER DATABASE [User] SET QUERY_STORE = OFF
GO
USE [User]
GO
/****** Object:  Table [dbo].[T_ChildrenInfo]    Script Date: 2020/7/18 18:47:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_ChildrenInfo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](max) NULL,
	[StuNo] [nvarchar](max) NULL,
	[Address] [nvarchar](max) NULL,
	[ParentName] [nvarchar](max) NULL,
	[SchoolName] [nvarchar](max) NULL,
 CONSTRAINT [PK_T_ChildrenInfo] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[T_ParentInfo]    Script Date: 2020/7/18 18:47:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_ParentInfo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ParentName] [nvarchar](max) NULL,
	[UserName] [nvarchar](max) NULL,
	[Password] [nvarchar](max) NULL,
	[ChildrenNum] [nvarchar](max) NULL,
	[SchoolName] [nvarchar](max) NULL,
 CONSTRAINT [PK_T_ParentInfo] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[T_UserInfo]    Script Date: 2020/7/18 18:47:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_UserInfo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](max) NULL,
	[UserName] [nvarchar](max) NULL,
	[Password] [nvarchar](max) NULL,
	[UserType] [nvarchar](max) NULL,
 CONSTRAINT [PK_T_UserInfo] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[T_ChildrenInfo] ON 
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (2, N'张三', N'2', N'福建省', N'珊珊', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (3, N'张一山', N'2', N'福建省福州市', N'珊珊', N'福州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (4, N'张三', N'1806017132', N'福建', N'张四', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (5, N'无敌', N'7', N'重庆', N'kkk', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (6, N'王峻熙', N'10', N'福建省福州市仓山区', N'王烨华', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (7, N'张嘉懿', N'11', N'福建省福州市仓山区', N'张天荣', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (8, N'李煜城', N'12', N'福建省福州市仓山区', N'李明杰', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (9, N'赵懿轩', N'13', N'福建省福州市仓山区', N'赵羽', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (10, N'杨煜祺', N'14', N'福建省福州市鼓楼区', N'杨弘文', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (11, N'孙正豪', N'15', N'福建省福州市鼓楼区', N'孙荣', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (12, N'吴昊然', N'16', N'福建省福州市鼓楼区', N'吴娟', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (13, N'郭志泽', N'17', N'福建省福州市鼓楼区', N'郭川川', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (14, N'靳烨伟', N'18', N'福建省福州市鼓楼区', N'靳东', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (15, N'马苑博', N'19', N'福建省福州市鼓楼区', N'马明', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (16, N'张鹏涛', N'20', N'福建省福州市鼓楼区', N'张伶边', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (17, N'叶红艳', N'1806117201', N'福建省福州市鼓楼区', N'叶明轩', N'福州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (18, N'孙志梅', N'1806117202', N'福建省福州市鼓楼区', N'孙乾明', N'福州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (19, N'刘雪恩', N'1806117203', N'福建省福州市鼓楼区', N'刘小二', N'福州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (20, N'严正明', N'1806117204', N'福建省福州市鼓楼区', N'严厉', N'福州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (21, N'樊梨花', N'1806117205', N'漳州市龙海区', N'樊余', N'福州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (22, N'范海霞', N'1806117206', N'漳州市龙海区', N'范宇', N'福州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (23, N'卢玉霞', N'1806117207', N'漳州市龙海区', N'卢弘文', N'福州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (24, N'张素珍', N'1806117208', N'漳州市龙海区', N'张庆余', N'福州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (25, N'刘晓芒', N'1806117209', N'漳州市龙海区', N'刘星', N'福州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (26, N'杨素萍', N'1806117210', N'漳州市龙海区', N'杨尚', N'福州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (27, N'潘晓娟', N'1806117211', N'漳州市龙海区', N'潘长江', N'福州职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (28, N'何云霞', N'1806117101', N'福建省宁德市蕉城区', N'何雨', N'厦门海洋职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (29, N'吴莎莎', N'1806117102', N'福建省宁德市蕉城区', N'吴山', N'厦门海洋职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (30, N'严夏红', N'1806117103', N'福建省宁德市蕉城区', N'严义', N'厦门海洋职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (31, N'闫春芝', N'1806117104', N'福建省宁德市蕉城区', N'闫明', N'厦门海洋职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (32, N'王晓正', N'1806117105', N'福建省宁德市蕉城区', N'王正谊', N'厦门海洋职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (33, N'徐小明', N'1806117106', N'福建省宁德市古田', N'徐珊', N'厦门海洋职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (34, N'王仕兰', N'1806117107', N'福建省宁德市古田', N'王益', N'厦门海洋职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (35, N'东方蓉', N'1806117108', N'福建省宁德市古田', N'东方西', N'厦门海洋职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (36, N'董飘萨', N'1806117109', N'福建省宁德市古田', N'董宇', N'厦门海洋职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (37, N'曹兰芳', N'1806117110', N'福建省宁德市古田', N'曹山', N'厦门海洋职业技术学院')
GO
INSERT [dbo].[T_ChildrenInfo] ([id], [Name], [StuNo], [Address], [ParentName], [SchoolName]) VALUES (38, N'吴春芳', N'1806117111', N'福建省宁德市古田', N'吴磊', N'厦门海洋职业技术学院')
GO
SET IDENTITY_INSERT [dbo].[T_ChildrenInfo] OFF
GO
SET IDENTITY_INSERT [dbo].[T_ParentInfo] ON 
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (0, N'珊珊', N'001', N'123456', N'2', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (1, N'张大', N'222', N'123456', N'2', N'福州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (3, N'张四', N'54007', N'540076', N'1806017132', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (7, N'kkk', N'666', N'666666', N'7', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (8, N'王烨华', N'王烨华1', N'123456', N'10', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (9, N'张天荣', N'张天荣1', N'123456', N'11', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (10, N'李明杰', N'李明杰1', N'123456', N'12', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (11, N'赵羽', N'赵羽1', N'123456', N'13', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (12, N'杨弘文', N'杨弘文1', N'123456', N'14', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (13, N'孙荣', N'孙荣1', N'123456', N'15', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (14, N'吴娟', N'吴娟1', N'123456', N'16', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (15, N'郭川川', N'郭川川1', N'123456', N'17', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (16, N'靳东', N'靳东', N'123456', N'18', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (17, N'马明', N'马明1', N'123456', N'19', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (18, N' 张伶边', N' 张伶边1', N'123456', N'20', N'漳州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (19, N'叶明轩', N'叶明轩1', N'123456', N'1806117201', N'福州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (20, N'孙乾明', N'孙乾明1', N'123456', N'1806117202', N'福州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (21, N'刘小二', N'刘小二1', N'123456', N'1806117203', N'福州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (22, N'严厉', N'严厉1', N'123456', N'1806117204', N'福州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (23, N'樊余', N'樊余1', N'123456', N'1806117205', N'福州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (24, N'范宇', N'范宇1', N'123456', N'1806117206', N'福州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (25, N'卢弘文', N'卢弘文1', N'123456', N'1806117207', N'福州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (26, N'张庆余', N'张庆余1', N'123456', N'1806117208', N'福州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (27, N'刘星', N'刘星1', N'123456', N'1806117209', N'福州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (28, N'杨尚', N'杨尚1', N'123456', N'1806117210', N'福州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (29, N'潘长江', N'潘长江1', N'123456', N'1806117211', N'福州职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (30, N'何雨', N'何雨1', N'123456', N'1806117101', N'厦门海洋职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (31, N'吴山', N'吴山1', N'123456', N'1806117102', N'厦门海洋职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (32, N'严义', N'严义1', N'123456', N'1806117103', N'厦门海洋职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (33, N'闫明', N'闫明1', N'123456', N'1806117104', N'厦门海洋职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (34, N'王正谊', N'王正谊1', N'123456', N'1806117105', N'厦门海洋职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (35, N'徐珊', N'徐珊1', N'123456', N'1806117106', N'厦门海洋职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (36, N'王益', N'王益1', N'123456', N'1806117107', N'厦门海洋职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (37, N'东方西', N'东方西1', N'123456', N'1806117108', N'厦门海洋职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (38, N'董宇', N'董宇1', N'123456', N'1806117109', N'厦门海洋职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (39, N'曹山', N'曹山1', N'123456', N'1806117110', N'厦门海洋职业技术学院')
GO
INSERT [dbo].[T_ParentInfo] ([id], [ParentName], [UserName], [Password], [ChildrenNum], [SchoolName]) VALUES (40, N'吴磊', N'吴磊1', N'123456', N'1806117111', N'厦门海洋职业技术学院')
GO
SET IDENTITY_INSERT [dbo].[T_ParentInfo] OFF
GO
SET IDENTITY_INSERT [dbo].[T_UserInfo] ON 
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (1, N'张三', N'张三', N'123456', N'厨房登记员')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (3, N'王五', N'123', N'123456', N'厨师')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (4, N'赵七', N'赵七', N'123456', N'厨师')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (5, N'赵七', N'456', N'123456', N'厨师')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (6, N'历时', N'2', N'123456', N'2')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (7, N'彭万里', N'彭万里1', N'123456', N'厨师')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (8, N'高大山', N'高大山1', N'123456', N'厨师')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (9, N'谢大海', N'谢大海1', N'123456', N'服务员')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (10, N'马宏宇', N'马宏宇1', N'123456', N'服务员')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (11, N'林莽', N'林莽1', N'123456', N'洗碗工')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (12, N'黄强辉', N'黄强辉1', N'123456', N'洗碗工')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (13, N'章汉夫', N'章汉夫1', N'123456', N'厨师')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (14, N'范长江', N'范长江1', N'123456', N'厨师')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (15, N'林君雄', N'林君雄1', N'123456', N'厨师')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (16, N'谭平山', N'谭平山1', N'123456', N'清洁工')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (17, N'朱希亮', N'朱希亮1', N'123456', N'清洁工')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (18, N'李四光', N'李四光1', N'123456', N'清洁工')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (19, N'甘铁生', N'甘铁生1', N'123456', N'清洁工')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (20, N'马继祖', N'马继祖1', N'123456', N'厨师')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (21, N'程孝先', N'程孝先1', N'123456', N'进货员')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (22, N'宗敬先', N'宗敬先1', N'123456', N'进货员')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (23, N'年广嗣', N'年广嗣1', N'123456', N'进货员')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (24, N'汤绍箕', N'汤绍箕1', N'123456', N'进货员')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (25, N'吕显祖', N'吕显祖1', N'123456', N'进货员')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (26, N'何光宗', N'何光宗1', N'123456', N'洗碗工')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (27, N'孙念祖', N'孙念祖1', N'123456', N'厨师')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (28, N'马建国', N'马建国1', N'123456', N'厨师')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (29, N'节振国', N'节振国1', N'123456', N'厨师')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (30, N'冯兴国', N'冯兴国1', N'123456', N'厨师')
GO
INSERT [dbo].[T_UserInfo] ([id], [Name], [UserName], [Password], [UserType]) VALUES (31, N'郝爱民', N'郝爱民2', N'123456', N'厨师')
GO
SET IDENTITY_INSERT [dbo].[T_UserInfo] OFF
GO
USE [master]
GO
ALTER DATABASE [User] SET  READ_WRITE 
GO
