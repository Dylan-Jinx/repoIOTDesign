USE [master]
GO
/****** Object:  Database [SchoolCookHouse]    Script Date: 2020/7/18 18:44:22 ******/
CREATE DATABASE [SchoolCookHouse]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'SchoolCookHouse', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\SchoolCookHouse.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'SchoolCookHouse_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\SchoolCookHouse_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [SchoolCookHouse] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [SchoolCookHouse].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [SchoolCookHouse] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [SchoolCookHouse] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [SchoolCookHouse] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [SchoolCookHouse] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [SchoolCookHouse] SET ARITHABORT OFF 
GO
ALTER DATABASE [SchoolCookHouse] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [SchoolCookHouse] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [SchoolCookHouse] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [SchoolCookHouse] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [SchoolCookHouse] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [SchoolCookHouse] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [SchoolCookHouse] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [SchoolCookHouse] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [SchoolCookHouse] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [SchoolCookHouse] SET  DISABLE_BROKER 
GO
ALTER DATABASE [SchoolCookHouse] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [SchoolCookHouse] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [SchoolCookHouse] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [SchoolCookHouse] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [SchoolCookHouse] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [SchoolCookHouse] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [SchoolCookHouse] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [SchoolCookHouse] SET RECOVERY FULL 
GO
ALTER DATABASE [SchoolCookHouse] SET  MULTI_USER 
GO
ALTER DATABASE [SchoolCookHouse] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [SchoolCookHouse] SET DB_CHAINING OFF 
GO
ALTER DATABASE [SchoolCookHouse] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [SchoolCookHouse] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [SchoolCookHouse] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'SchoolCookHouse', N'ON'
GO
ALTER DATABASE [SchoolCookHouse] SET QUERY_STORE = OFF
GO
USE [SchoolCookHouse]
GO
/****** Object:  Table [dbo].[T_Bill]    Script Date: 2020/7/18 18:44:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_Bill](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Price] [float] NULL,
	[BillDatetime] [datetime] NULL,
	[Conductor] [nvarchar](max) NULL,
	[Remark] [nvarchar](max) NULL,
 CONSTRAINT [PK_T_Bill] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[T_CookHouseInfo]    Script Date: 2020/7/18 18:44:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_CookHouseInfo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[CookHouseName] [nvarchar](max) NULL,
	[Temperature] [float] NULL,
	[Humidity] [float] NULL,
	[ReportTime] [nvarchar](max) NULL,
 CONSTRAINT [PK_T_CookHouseInfo] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[T_Staff]    Script Date: 2020/7/18 18:44:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_Staff](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[StaffName] [nvarchar](max) NULL,
	[Telephone] [nvarchar](max) NULL,
	[Image] [nvarchar](max) NULL,
	[Position] [nvarchar](max) NULL,
 CONSTRAINT [PK_T_Staff] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[T_Storage]    Script Date: 2020/7/18 18:44:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_Storage](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ProductInfo] [nvarchar](max) NULL,
	[Price] [float] NULL,
	[StorageTime] [datetime] NULL,
	[Remark] [nvarchar](max) NULL,
 CONSTRAINT [PK_T_Storage] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[T_Bill] ON 
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (1, 500, CAST(N'2020-07-01T15:20:00.000' AS DateTime), N'张三', N'漳州职业技术学院-第一食堂 500元西红柿')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (2, 300, CAST(N'2020-07-09T11:23:15.000' AS DateTime), N'李四', N'漳州职业技术学院-第二食堂 300元土豆')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (3, 500, CAST(N'2020-04-09T11:23:15.000' AS DateTime), N'李四', N'漳州职业技术学院-第二食堂 500元大白菜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (4, 600, CAST(N'2020-05-09T11:23:15.000' AS DateTime), N'王五', N'漳州职业技术学院-第三食堂 600元大米')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (5, 100, CAST(N'2020-06-09T10:23:00.000' AS DateTime), N'王五', N'漳州职业技术学院-第三食堂 100元大葱')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (6, 200, CAST(N'2020-06-15T10:00:17.000' AS DateTime), N'王五', N'漳州职业技术学院-第三食堂 200元姜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (7, 200, CAST(N'2020-01-15T10:00:17.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 200元姜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (8, 500, CAST(N'2020-01-17T10:00:17.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 500元猪肉')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (9, 700, CAST(N'2020-01-18T10:00:17.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 700元牛肉')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (10, 700, CAST(N'2020-03-18T12:00:17.000' AS DateTime), N'田七', N'福州职业技术学院-第二食堂 700元鸡肉')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (11, 230, CAST(N'2020-03-18T09:00:17.000' AS DateTime), N'田七', N'福州职业技术学院-第二食堂 230元青椒')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (12, 1000, CAST(N'2020-04-18T09:00:17.000' AS DateTime), N'田七', N'福州职业技术学院-第二食堂 200元青椒、300元鸡肉、300元猪肉、200元大蒜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (13, 100, CAST(N'2020-05-18T09:00:17.000' AS DateTime), N'张三', N'漳州职业技术学院-第一食堂 100辣椒')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (14, 400, CAST(N'2020-06-18T08:00:17.000' AS DateTime), N'张三', N'漳州职业技术学院-第一食堂 400元大米')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (15, 400, CAST(N'2020-07-02T09:30:17.000' AS DateTime), N'张三', N'漳州职业技术学院-第一食堂 400元南瓜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (16, 500, CAST(N'2020-07-10T09:30:17.000' AS DateTime), N'张三', N'漳州职业技术学院-第一食堂 500元青菜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (17, 600, CAST(N'2020-06-01T10:30:17.000' AS DateTime), N'张三', N'漳州职业技术学院-第一食堂 600元排骨')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (18, 500, CAST(N'2020-06-02T10:30:17.000' AS DateTime), N'张三', N'漳州职业技术学院-第一食堂 100元土豆、200元南瓜、200元青菜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (19, 800, CAST(N'2020-06-03T10:45:00.000' AS DateTime), N'张三', N'漳州职业技术学院-第一食堂 500元猪肉、100元姜、100元葱、100元大蒜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (20, 800, CAST(N'2020-05-03T10:55:00.000' AS DateTime), N'张亮亮', N'厦门海洋职业技术学院-第一食堂 500元猪肉、100元姜、100元葱、100元大蒜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (21, 200, CAST(N'2020-05-04T10:55:00.000' AS DateTime), N'张亮亮', N'厦门海洋职业技术学院-第一食堂 200元大米')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (22, 400, CAST(N'2020-05-05T10:55:00.000' AS DateTime), N'张亮亮', N'厦门海洋职业技术学院-第一食堂 200元南瓜、200元西兰花')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (23, 600, CAST(N'2020-05-06T10:55:00.000' AS DateTime), N'张亮亮', N'厦门海洋职业技术学院-第一食堂 600元猪肉')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (24, 100, CAST(N'2020-05-07T10:11:00.000' AS DateTime), N'张亮亮', N'厦门海洋职业技术学院-第一食堂 100元青椒')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (25, 400, CAST(N'2020-05-08T10:11:00.000' AS DateTime), N'张亮亮', N'厦门海洋职业技术学院-第一食堂 200元南瓜、200元黄瓜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (26, 200, CAST(N'2020-05-09T09:11:00.000' AS DateTime), N'张亮亮', N'厦门海洋职业技术学院-第一食堂 200元辣椒')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (27, 1200, CAST(N'2020-05-09T09:11:00.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 1200元大米')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (28, 500, CAST(N'2020-05-10T10:11:00.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 500元南瓜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (29, 1500, CAST(N'2020-05-11T10:11:00.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 500元青菜、1000元鸡肉')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (30, 600, CAST(N'2020-05-12T10:11:00.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 300元牛肉、300元鸡蛋')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (31, 600, CAST(N'2020-05-13T10:11:00.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 600元排骨')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (32, 1000, CAST(N'2020-07-18T09:00:17.000' AS DateTime), N'田七', N'福州职业技术学院-第二食堂 200元青椒、300元鸡肉、300元猪肉、200元大蒜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (33, 800, CAST(N'2020-07-03T10:55:00.000' AS DateTime), N'张亮亮', N'厦门海洋职业技术学院-第一食堂 500元猪肉、100元姜、100元葱、100元大蒜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (34, 400, CAST(N'2020-07-08T10:11:00.000' AS DateTime), N'张亮亮', N'厦门海洋职业技术学院-第一食堂 200元南瓜、200元黄瓜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (35, 600, CAST(N'2020-07-12T10:11:00.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 300元牛肉、300元鸡蛋')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (36, 300, CAST(N'2020-07-13T10:11:00.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 300元排骨')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (37, 100, CAST(N'2020-07-09T10:23:00.000' AS DateTime), N'王五', N'漳州职业技术学院-第三食堂 100元大葱')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (38, 500, CAST(N'2020-03-09T11:23:15.000' AS DateTime), N'李四', N'漳州职业技术学院-第二食堂 500元大白菜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (39, 500, CAST(N'2020-04-09T11:23:15.000' AS DateTime), N'李四', N'漳州职业技术学院-第二食堂 500元大白菜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (40, 400, CAST(N'2020-04-08T10:11:00.000' AS DateTime), N'张亮亮', N'厦门海洋职业技术学院-第一食堂 200元南瓜、200元黄瓜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (41, 400, CAST(N'2020-03-08T10:11:00.000' AS DateTime), N'张亮亮', N'厦门海洋职业技术学院-第一食堂 200元南瓜、200元黄瓜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (42, 300, CAST(N'2020-03-13T10:11:00.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 300元排骨')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (43, 300, CAST(N'2020-04-13T10:11:00.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 300元排骨')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (44, 600, CAST(N'2020-05-13T10:11:00.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 600元排骨')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (45, 1000, CAST(N'2020-03-18T09:00:17.000' AS DateTime), N'田七', N'福州职业技术学院-第二食堂 200元青椒、300元鸡肉、300元猪肉、200元大蒜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (46, 500, CAST(N'2020-03-11T10:11:00.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 300元青菜、200元鸡肉')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (47, 500, CAST(N'2020-04-11T10:11:00.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 300元青菜、200元鸡肉')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (48, 500, CAST(N'2020-06-11T10:11:00.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 300元青菜、200元鸡肉')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (49, 500, CAST(N'2020-07-11T10:11:00.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 300元青菜、200元鸡肉')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (50, 500, CAST(N'2020-03-01T15:20:00.000' AS DateTime), N'张三', N'漳州职业技术学院-第一食堂 500元西红柿')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (51, 500, CAST(N'2020-04-01T15:20:00.000' AS DateTime), N'张三', N'漳州职业技术学院-第一食堂 500元西红柿')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (52, 500, CAST(N'2020-05-01T15:20:00.000' AS DateTime), N'张三', N'漳州职业技术学院-第一食堂 500元西红柿')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (53, 500, CAST(N'2020-06-01T15:20:00.000' AS DateTime), N'张三', N'漳州职业技术学院-第一食堂 500元西红柿')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (54, 700, CAST(N'2020-07-18T12:00:17.000' AS DateTime), N'田七', N'福州职业技术学院-第二食堂 700元鸡肉')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (55, 500, CAST(N'2020-07-09T11:23:15.000' AS DateTime), N'李四', N'漳州职业技术学院-第二食堂 500元大白菜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (56, 2300, CAST(N'2020-07-19T10:55:00.000' AS DateTime), N'张亮亮', N'厦门海洋职业技术学院-第一食堂 1400元猪肉、300元姜、300元葱、300元大蒜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (57, 1200, CAST(N'2020-06-17T10:00:17.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 1200元猪肉')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (58, 500, CAST(N'2020-06-17T10:00:17.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 500元鸡肉')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (59, 2000, CAST(N'2020-04-12T10:11:00.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 1200元牛肉、800元鸡蛋')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (60, 800, CAST(N'2020-06-03T10:55:00.000' AS DateTime), N'张亮亮', N'厦门海洋职业技术学院-第一食堂 500元猪肉、100元姜、100元葱、100元大蒜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (61, 1200, CAST(N'2020-06-09T09:11:00.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 1200元大米')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (62, 2000, CAST(N'2020-03-12T10:11:00.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 1200元牛肉、800元鸡蛋')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (63, 1000, CAST(N'2020-04-18T09:00:17.000' AS DateTime), N'田七', N'福州职业技术学院-第二食堂 200元青椒、300元鸡肉、300元猪肉、200元大蒜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (64, 500, CAST(N'2020-03-01T15:20:00.000' AS DateTime), N'张三', N'漳州职业技术学院-第一食堂 500元西红柿')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (65, 500, CAST(N'2020-04-01T15:20:00.000' AS DateTime), N'张三', N'漳州职业技术学院-第一食堂 500元西红柿')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (66, 600, CAST(N'2020-04-13T10:11:00.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 600元排骨')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (67, 600, CAST(N'2020-03-13T10:11:00.000' AS DateTime), N'赵六', N'福州职业技术学院-第一食堂 600元排骨')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (68, 2300, CAST(N'2020-03-19T10:55:00.000' AS DateTime), N'张亮亮', N'厦门海洋职业技术学院-第一食堂 1400元猪肉、300元姜、300元葱、300元大蒜')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (69, 3300, CAST(N'2020-06-19T10:55:00.000' AS DateTime), N'张亮亮', N'厦门海洋职业技术学院-第一食堂 1400元猪肉、300元姜、300元葱、300元大蒜、500元西红柿、500元鸡蛋')
GO
INSERT [dbo].[T_Bill] ([id], [Price], [BillDatetime], [Conductor], [Remark]) VALUES (70, 2300, CAST(N'2020-04-19T10:55:00.000' AS DateTime), N'张一', N'厦门海洋职业技术学院-第一食堂 1400元猪肉、300元姜、300元葱、300元大蒜')
GO
SET IDENTITY_INSERT [dbo].[T_Bill] OFF
GO
SET IDENTITY_INSERT [dbo].[T_CookHouseInfo] ON 
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (1, N'漳州职业技术学院-第二食堂', 36, 70, N'2020/7/1 15:18')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (3, N'漳州职业技术学院-第一食堂', 30, 58, N'202/6/1 15:30:00 ')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (4, N'漳州职业技术学院-第一食堂', 30, 28, N'202/6/2 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (5, N'漳州职业技术学院-第一食堂', 29, 25, N'202/6/3 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (6, N'漳州职业技术学院-第一食堂', 32, 25, N'202/6/4 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (7, N'漳州职业技术学院-第一食堂', 26, 24, N'202/6/5 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (8, N'漳州职业技术学院-第一食堂', 34, 30, N'202/6/6 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (9, N'漳州职业技术学院-第一食堂', 31, 30, N'202/6/7 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (10, N'漳州职业技术学院-第一食堂', 31, 22, N'202/6/8 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (11, N'福州职业技术学院-第一食堂', 31, 22, N'202/6/1 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (12, N'福州职业技术学院-第一食堂', 30, 22, N'202/6/2 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (13, N'福州职业技术学院-第一食堂', 27, 26, N'202/6/3 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (14, N'福州职业技术学院-第一食堂', 28, 26, N'202/6/4 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (15, N'福州职业技术学院-第一食堂', 29, 26, N'202/6/5 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (16, N'福州职业技术学院-第一食堂', 30, 26, N'202/6/6 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (17, N'福州职业技术学院-第一食堂', 31, 26, N'202/6/7 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (18, N'福州职业技术学院-第一食堂', 32, 26, N'202/6/8 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (19, N'福州职业技术学院-第二食堂', 32, 26, N'202/7/1 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (20, N'福州职业技术学院-第二食堂', 31, 26, N'202/7/2 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (21, N'福州职业技术学院-第二食堂', 30, 27, N'202/7/3 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (22, N'福州职业技术学院-第二食堂', 29, 28, N'202/7/4 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (23, N'厦门海洋职业技术学院-第一食堂', 29, 28, N'202/7/1 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (24, N'厦门海洋职业技术学院-第一食堂', 28, 28, N'202/7/2 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (25, N'厦门海洋职业技术学院-第一食堂', 27, 29, N'202/7/3 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (26, N'厦门海洋职业技术学院-第一食堂', 28, 30, N'202/7/4 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (27, N'厦门海洋职业技术学院-第一食堂', 25, 30, N'202/7/5 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (28, N'厦门海洋职业技术学院-第一食堂', 30, 29, N'202/7/6 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (29, N'厦门海洋职业技术学院-第一食堂', 31, 29, N'202/7/7 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (30, N'厦门海洋职业技术学院-第一食堂', 32, 30, N'202/7/8 15:30:00')
GO
INSERT [dbo].[T_CookHouseInfo] ([id], [CookHouseName], [Temperature], [Humidity], [ReportTime]) VALUES (31, N'漳州职业技术学院-第二食堂', 36, 10, N'2020/7/1 15:18')
GO
SET IDENTITY_INSERT [dbo].[T_CookHouseInfo] OFF
GO
SET IDENTITY_INSERT [dbo].[T_Staff] ON 
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (3, N'李四', N'13691382489', N'File/Uploads/李四.jpg', N'漳州职业技术学院-第一食堂-负责人')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (4, N'于学忠', N'13577608888', N'File/Uploads/于学忠.jpg', N'漳州职业技术学院-第一食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (5, N'马连良', N'13213245432', N'File/Uploads/马连良.jpg', N'漳州职业技术学院-第一食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (6, N'胡宝善', N'13213244432', N'File/Uploads/胡宝善.jpg', N'漳州职业技术学院-第一食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (7, N'李宗仁', N'18735318888', N'File/Uploads/李宗仁.jpg', N'漳州职业技术学院-第一食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (8, N'洪学智', N'15815179846', N'File/Uploads/洪学智.jpg', N'漳州职业技术学院-第二食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (9, N'余克勤', N'15652152727', N'File/Uploads/余克勤.jpg', N'漳州职业技术学院-第二食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (10, N'吴克俭', N' 15140454253 ', N'File/Uploads/吴克俭.jpg', N'漳州职业技术学院-第二食堂-负责人')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (11, N'杨惟义', N' 15234524706 ', N'File/Uploads/杨惟义.jpg', N'漳州职业技术学院-第二食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (12, N'李文信', N'15834794444', N'File/Uploads/李文信.jpg', N'漳州职业技术学院-第二食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (13, N'王德茂', N'15000777752', N'File/Uploads/王德茂.jpg', N'漳州职业技术学院-第二食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (14, N'李书诚', N'13902778883', N'File/Uploads/李书诚.jpg', N'漳州职业技术学院-第二食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (15, N'杨勇', N'13902790108', N'File/Uploads/杨勇.jpg', N'福州职业技术学院-第一食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (16, N'高尚德', N'13902701832', N'File/Uploads/高尚德.jpg', N'福州职业技术学院-第一食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (17, N'刁富贵', N'13113141314', N'File/Uploads/刁富贵.jpg', N'福州职业技术学院-第一食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (18, N'汤念祖', N'13693357480', N'File/Uploads/汤念祖.jpg', N'福州职业技术学院-第一食堂-负责人')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (19, N'吕奉先', N'18870881867', N'File/Uploads/吕奉先.jpg', N'福州职业技术学院-第一食堂-洗碗工')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (20, N'何光宗', N'15590085523', N'File/Uploads/何光宗.jpg', N'福州职业技术学院-第二食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (21, N'冷德友', N'13905678673', N'File/Uploads/冷德友.jpg', N'福州职业技术学院-第二食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (22, N'安怡孙', N' 18874838565 ', N'File/Uploads/安怡孙.jpg', N'福州职业技术学院-第二食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (23, N'贾德善', N' 15769000120 ', N'File/Uploads/贾德善.jpg', N'福州职业技术学院-第二食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (24, N'蔡德霖', N'13784880245', N'File/Uploads/蔡德霖.jpg', N'福州职业技术学院-第二食堂-负责人')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (25, N'关仁', N'13903186655', N'File/Uploads/关仁.jpg', N'厦门海洋职业技术学院-第一食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (26, N'孙天民', N'15367485395', N'File/Uploads/孙天民.jpg', N'厦门海洋职业技术学院-第一食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (27, N'赵大华', N'13903186615', N'File/Uploads/赵大华.jpg', N'厦门海洋职业技术学院-第一食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (28, N'赵进喜', N'15713939555', N'File/Uploads/赵进喜.jpg', N'厦门海洋职业技术学院-第一食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (29, N'赵德荣', N' 18236066456 ', N'File/Uploads/赵德荣.jpg', N'厦门海洋职业技术学院-第一食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (30, N'赵德茂', N'18239367654', N'File/Uploads/赵德茂.jpg', N'厦门海洋职业技术学院-第二食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (31, N'钱汉祥', N'15868807180', N'File/Uploads/钱汉祥.jpg', N'厦门海洋职业技术学院-第二食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (32, N'钱运高', N'15971345672', N'File/Uploads/钱运高.jpg', N'厦门海洋职业技术学院-第二食堂-采购员')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (33, N'钱生禄', N'13600322949', N'File/Uploads/钱生禄.jpg', N'厦门海洋职业技术学院-第二食堂-负责人')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (34, N'孙寿康', N'13424392181', N'File/Uploads/孙寿康.jpg', N'厦门海洋职业技术学院-第一食堂-负责人')
GO
INSERT [dbo].[T_Staff] ([id], [StaffName], [Telephone], [Image], [Position]) VALUES (35, N'彭震川', N'15856040835', N'File/Uploads/彭震川.png', N'漳州职业技术学院-第二食堂-收银员')
GO
SET IDENTITY_INSERT [dbo].[T_Staff] OFF
GO
SET IDENTITY_INSERT [dbo].[T_Storage] ON 
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (1, N'西红柿', 5.8000001907348633, CAST(N'2020-06-30T16:55:00.000' AS DateTime), N'新鲜的')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (2, N'西瓜', 12, CAST(N'2020-04-05T00:00:00.000' AS DateTime), N'888')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (3, N'kkk', 5, CAST(N'2020-02-03T00:00:00.000' AS DateTime), N'555')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (5, N'ooo', 6, CAST(N'2020-07-15T00:00:00.000' AS DateTime), N'lll')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (6, N'南瓜', 200, CAST(N'2020-06-01T15:30:00.000' AS DateTime), N'漳州职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (7, N'冬瓜', 200, CAST(N'2020-06-01T15:30:00.000' AS DateTime), N'漳州职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (8, N'大米', 1000, CAST(N'2020-06-02T15:30:00.000' AS DateTime), N'漳州职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (9, N'香菜', 100, CAST(N'2020-06-02T15:30:00.000' AS DateTime), N'漳州职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (10, N'大蒜', 200, CAST(N'2020-06-02T15:30:00.000' AS DateTime), N'漳州职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (11, N'葱', 200, CAST(N'2020-06-02T15:30:00.000' AS DateTime), N'漳州职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (12, N'姜', 200, CAST(N'2020-06-02T15:30:00.000' AS DateTime), N'漳州职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (13, N'牛肉', 500, CAST(N'2020-06-10T15:30:00.000' AS DateTime), N'福州职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (14, N'鸡肉', 300, CAST(N'2020-06-10T15:30:00.000' AS DateTime), N'福州职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (15, N'猪肉', 400, CAST(N'2020-06-11T15:30:00.000' AS DateTime), N'福州职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (16, N'青椒', 200, CAST(N'2020-06-12T10:30:00.000' AS DateTime), N'福州职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (17, N'辣椒', 200, CAST(N'2020-06-13T10:30:00.000' AS DateTime), N'福州职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (18, N'排骨', 500, CAST(N'2020-06-14T11:30:00.000' AS DateTime), N'福州职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (19, N'酱油', 200, CAST(N'2020-06-15T11:30:00.000' AS DateTime), N'福州职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (20, N'大米', 1000, CAST(N'2020-06-16T11:30:00.000' AS DateTime), N'福州职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (21, N'大米', 800, CAST(N'2020-07-01T12:30:00.000' AS DateTime), N'厦门海洋职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (22, N'西瓜', 100, CAST(N'2020-07-01T12:30:00.000' AS DateTime), N'厦门海洋职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (23, N'丝瓜', 300, CAST(N'2020-07-02T12:30:00.000' AS DateTime), N'厦门海洋职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (24, N'辣椒', 200, CAST(N'2020-07-03T12:30:00.000' AS DateTime), N'厦门海洋职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (25, N'青椒', 300, CAST(N'2020-07-03T12:30:00.000' AS DateTime), N'厦门海洋职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (26, N'上海青', 400, CAST(N'2020-07-04T12:30:00.000' AS DateTime), N'厦门海洋职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (27, N'五花肉', 530, CAST(N'2020-07-05T12:30:00.000' AS DateTime), N'厦门海洋职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (28, N'牛肉', 600, CAST(N'2020-07-06T12:30:00.000' AS DateTime), N'厦门海洋职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (29, N'西兰花', 300, CAST(N'2020-07-07T12:30:00.000' AS DateTime), N'厦门海洋职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (30, N'土豆', 200, CAST(N'2020-07-07T12:30:00.000' AS DateTime), N'厦门海洋职业技术学院-第一食堂')
GO
INSERT [dbo].[T_Storage] ([id], [ProductInfo], [Price], [StorageTime], [Remark]) VALUES (31, N'南瓜', 300, CAST(N'2020-07-08T11:30:00.000' AS DateTime), N'厦门海洋职业技术学院-第一食堂')
GO
SET IDENTITY_INSERT [dbo].[T_Storage] OFF
GO
USE [master]
GO
ALTER DATABASE [SchoolCookHouse] SET  READ_WRITE 
GO
