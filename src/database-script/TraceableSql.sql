USE [master]
GO
/****** Object:  Database [Traceable]    Script Date: 2020/7/18 18:45:14 ******/
CREATE DATABASE [Traceable]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Traceable', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Traceable.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Traceable_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Traceable_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Traceable] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Traceable].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Traceable] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Traceable] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Traceable] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Traceable] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Traceable] SET ARITHABORT OFF 
GO
ALTER DATABASE [Traceable] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Traceable] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Traceable] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Traceable] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Traceable] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Traceable] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Traceable] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Traceable] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Traceable] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Traceable] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Traceable] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Traceable] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Traceable] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Traceable] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Traceable] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Traceable] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Traceable] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Traceable] SET RECOVERY FULL 
GO
ALTER DATABASE [Traceable] SET  MULTI_USER 
GO
ALTER DATABASE [Traceable] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Traceable] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Traceable] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Traceable] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Traceable] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'Traceable', N'ON'
GO
ALTER DATABASE [Traceable] SET QUERY_STORE = OFF
GO
USE [Traceable]
GO
/****** Object:  Table [dbo].[T_PlantInfo]    Script Date: 2020/7/18 18:45:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_PlantInfo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[SeedSource] [nvarchar](max) NULL,
	[PlantFieldNum] [nvarchar](max) NULL,
	[PlantTime] [datetime] NULL,
	[HarvestTime] [datetime] NULL,
	[Remark] [nvarchar](max) NULL,
 CONSTRAINT [PK_T_PlantInfo] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[T_ProductionBaseInfo]    Script Date: 2020/7/18 18:45:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_ProductionBaseInfo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](max) NULL,
	[Category] [nvarchar](max) NULL,
	[ResponsibleName] [nvarchar](max) NULL,
	[Telephone] [nvarchar](max) NULL,
	[Image] [nvarchar](max) NULL,
 CONSTRAINT [PK_T_ProductionBaseInfo] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[T_ProductionBaseStaff]    Script Date: 2020/7/18 18:45:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_ProductionBaseStaff](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[StaffName] [nvarchar](max) NULL,
	[Telephone] [nvarchar](max) NULL,
	[ProductionBaseName] [nvarchar](max) NULL,
	[Image] [nvarchar](max) NULL,
	[Position] [nvarchar](max) NULL,
 CONSTRAINT [PK_T_ProductionBaseStaff] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[T_ProductNumInfo]    Script Date: 2020/7/18 18:45:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_ProductNumInfo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ProductNumber] [nvarchar](max) NULL,
	[ProductInfo] [nvarchar](max) NULL,
	[ProductionBase] [nvarchar](max) NULL,
	[WareHouse] [nvarchar](max) NULL,
	[Image] [nvarchar](max) NULL,
 CONSTRAINT [PK_T_ProductNumInfo] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[T_TransportationCompanyInfo]    Script Date: 2020/7/18 18:45:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_TransportationCompanyInfo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](max) NULL,
	[Address] [nvarchar](max) NULL,
	[ResponsibleName] [nvarchar](max) NULL,
	[Telephone] [nvarchar](max) NULL,
 CONSTRAINT [PK_T_TransportationCompanyInfo] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[T_TransportationEnvironmentInfo]    Script Date: 2020/7/18 18:45:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_TransportationEnvironmentInfo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Plate] [nvarchar](max) NULL,
	[Driver] [nvarchar](max) NULL,
	[Telephone] [nvarchar](max) NULL,
	[DateTime] [datetime] NULL,
	[Temperature] [float] NULL,
	[Humidity] [float] NULL,
	[ProductNumber] [nvarchar](max) NULL,
 CONSTRAINT [PK_T_TransportationEnvironmentInfo] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[T_TransportCompanyStaff]    Script Date: 2020/7/18 18:45:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_TransportCompanyStaff](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[StaffName] [nvarchar](max) NULL,
	[Telephone] [nvarchar](max) NULL,
	[TransPortCompanyName] [nvarchar](max) NULL,
	[Image] [nvarchar](max) NULL,
 CONSTRAINT [PK_T_TransportCompanyStaff] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[T_WarehouseInfo]    Script Date: 2020/7/18 18:45:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_WarehouseInfo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](max) NULL,
	[Location] [nvarchar](max) NULL,
	[ResponsiblePerson] [nvarchar](max) NULL,
	[Telephone] [nvarchar](max) NULL,
	[Temperature] [float] NULL,
	[Humidity] [float] NULL,
	[Remark] [nvarchar](max) NULL,
 CONSTRAINT [PK_T_WarehouseInfo] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[T_WaterQualityInfo]    Script Date: 2020/7/18 18:45:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[T_WaterQualityInfo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[DateOfSampling] [datetime] NULL,
	[PH] [float] NULL,
	[ComprehensiveEvaluation] [nvarchar](max) NULL,
	[Remark] [nvarchar](max) NULL,
	[Image] [nvarchar](max) NULL,
 CONSTRAINT [PK_T_WaterQualityInfo] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[T_PlantInfo] ON 
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (1, N'江西东乡', N'云霄东厦水稻种植基地东一区', CAST(N'2020-07-06T11:23:58.370' AS DateTime), CAST(N'2020-09-06T03:21:25.477' AS DateTime), N'受地区气候影响，估算该水稻种植到成熟的区间应该是三个月')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (2, N'海南三亚', N'云霄东厦水稻种植基地东二区', CAST(N'2020-07-06T11:26:54.230' AS DateTime), CAST(N'2020-10-06T11:25:55.233' AS DateTime), N'受地区气候影响，估算该水稻种植到成熟的区间应该是四个月')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (3, N'山东寿光', N'云霄东厦西红柿种植基地西三区', CAST(N'2020-07-06T14:38:24.710' AS DateTime), CAST(N'2020-12-06T14:36:43.697' AS DateTime), N'估测成熟周期应该是110天-170天')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (4, N'山东省寿光', N'山东省寿光市甜椒种植基地', CAST(N'2020-07-10T19:43:15.563' AS DateTime), CAST(N'2020-07-10T08:52:03.733' AS DateTime), N'该品种为无限生长型，植株高大，茎秆粗壮，生长势强，属中熟品种，熟期77～82天。')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (5, N'山东省寿光', N'山东省寿光市辣椒种植基地', CAST(N'2020-07-10T19:45:34.163' AS DateTime), CAST(N'2020-12-10T08:52:03.733' AS DateTime), N'辣椒的生长周期在4-5个月。种子播种后大约10-15天才可以长出真叶。幼苗期是在开始长真叶到长第一个花蕾，这个时间大约有40天。从第一个花蕾到结第一个果实，这个时间称为始花期，大约20-30天。之后为结果期，一般在30-50天左右。”')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (6, N'山东省寿光', N'山东省寿光市密刺黄瓜种植基地', CAST(N'2020-07-10T19:47:24.207' AS DateTime), CAST(N'2020-12-10T08:52:03.733' AS DateTime), N'黄瓜bai的生长周期是60天，黄瓜的雌du花本身就是有小果和zhi花组成，一开始时见小果，然后开花dao，花落果长。”')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (7, N'山东省寿光', N'山东省寿光市西瓜种植基地', CAST(N'2020-07-10T19:52:14.473' AS DateTime), CAST(N'2020-10-10T11:51:17.147' AS DateTime), N'西瓜属一年生蔓性作物，从种子到种子为一个生育周期，全过程一般需100-120天。')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (8, N'广西省梧州市藤县', N'藤县塘步镇禤洲蔬菜-茄子示范基地', CAST(N'2020-07-10T19:57:47.097' AS DateTime), CAST(N'2020-11-10T11:51:17.147' AS DateTime), N'茄子的生长周期分为发芽期、幼苗期以及开花结果期，大概的时间是在4个月左右。')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (9, N'广西省梧州市藤县', N'藤县塘步镇禤洲蔬菜-芹菜示范基地', CAST(N'2020-07-10T19:59:25.857' AS DateTime), CAST(N'2020-11-10T11:51:17.147' AS DateTime), N'芹菜的生长期一般来说,是生长期是三个月。')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (10, N'云南省元谋县', N'云南元谋番茄反季节菜生产基地', CAST(N'2020-07-10T20:02:05.637' AS DateTime), CAST(N'2020-11-10T11:51:17.147' AS DateTime), N'番茄生长周期大概需要110-170天。 ')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (11, N'云南省元谋县', N'云南元谋圆葱反季节菜生产基地', CAST(N'2020-07-10T20:05:36.133' AS DateTime), CAST(N'2020-12-10T12:04:39.460' AS DateTime), N'圆葱的成熟期约为330天。')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (12, N'云南省元谋县', N'云南元谋香葱反季节菜生产基地', CAST(N'2020-07-10T20:06:05.450' AS DateTime), CAST(N'2020-12-10T12:04:39.460' AS DateTime), N'一般播种后60—80天采收，移栽后30天可陆续采收。')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (13, N'云南省元谋县', N'云南元谋菜豆反季节菜生产基地', CAST(N'2020-07-10T20:06:46.100' AS DateTime), CAST(N'2020-12-10T12:04:39.460' AS DateTime), N'矮生品种一般播种后30～40天便进入开花结荚期，嫩荚采收期20～30天；蔓生品种一般播种后50～70天进入开花结荚期，嫩荚采收期45～70天。')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (14, N'云南省元谋县', N'云南元谋牛蒡反季节菜生产基地', CAST(N'2020-07-10T20:07:11.877' AS DateTime), CAST(N'2020-12-10T12:04:39.460' AS DateTime), N'春季3月下旬至5月上旬（采用地膜覆盖）播种，10月至11月收获；秋季9月下旬至10月中旬播种，也要采用地膜覆盖，越冬期以小拱棚地膜覆盖为好，来年4～5月份收获。 ')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (15, N'广东湛江徐闻县', N'广东湛江徐闻县蔬菜-四季豆基地', CAST(N'2020-07-10T20:11:02.123' AS DateTime), CAST(N'2020-09-10T12:10:13.970' AS DateTime), N'四季豆生长周期80—90天。')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (16, N'广东湛江徐闻县', N'广东湛江徐闻县蔬菜-豆角基地', CAST(N'2020-07-10T20:11:31.060' AS DateTime), CAST(N'2020-09-10T12:10:13.970' AS DateTime), N'大概为两到三个月,与天气有关系,雨水较多的时候,长势比较好,比较干旱的话,生长期就很短,豆角结果的数量也少。')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (17, N'广东湛江徐闻县', N'广东湛江徐闻县蔬菜-苦瓜基地', CAST(N'2020-07-10T20:11:59.947' AS DateTime), CAST(N'2020-09-10T12:10:13.970' AS DateTime), N'播种育苗苦瓜不同品种搭配能从2月中旬播至7月中旬,苦瓜整个生育过程需80—100天左右。')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (18, N'广东湛江徐闻县', N'广东湛江徐闻县蔬菜-黄瓜基地', CAST(N'2020-07-10T20:12:15.030' AS DateTime), CAST(N'2020-09-10T12:10:13.970' AS DateTime), N'黄瓜的生长期比较长。首份后10天左右即可采收。播种到定植需45天左右,定植到根瓜坐柱约30天左右,采收期1-2个月。')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (19, N'广东湛江徐闻县', N'广东湛江徐闻县蔬菜-辣椒基地', CAST(N'2020-07-10T20:12:38.143' AS DateTime), CAST(N'2020-09-10T12:10:13.970' AS DateTime), N'辣椒的生长周期在4-5个月。')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (20, N'广东湛江徐闻县', N'广东湛江徐闻县蔬菜-玉米基地', CAST(N'2020-07-10T20:13:02.387' AS DateTime), CAST(N'2020-09-10T12:10:13.970' AS DateTime), N'玉米的生长周期最短是70天。 ')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (21, N'广东湛江徐闻县', N'广东湛江徐闻县蔬菜-花生基地', CAST(N'2020-07-10T20:13:30.580' AS DateTime), CAST(N'2020-10-10T12:10:13.970' AS DateTime), N'花生的种植周期大概需要100-150天,个别晚熟品种可达180天,之后才能成熟收获,花生一般是4月播种,江淮地区8-9月收获,北方地区则是9月份后收获。 ')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (22, N'云南省曲靖市', N'曲靖市蔬菜-南瓜基地', CAST(N'2020-07-10T20:16:35.910' AS DateTime), CAST(N'2020-10-10T12:10:13.970' AS DateTime), N'南瓜的生长期多久:南瓜生长期大约为4-6个月,根据气候决定。 ')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (23, N'云南省曲靖市', N'曲靖市蔬菜-蒜基地', CAST(N'2020-07-10T20:17:04.503' AS DateTime), CAST(N'2020-10-10T12:10:13.970' AS DateTime), N'蒜的生育周期的长短,因播种期不同而存在很大的差异。春季播种的大蒜生育期较短,一般为90~110d;秋季播种的大蒜因要经过一定天数的低温春化,生育期一般长达220~280d。 ')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (24, N'云南省曲靖市', N'曲靖市蔬菜-油麦菜基地', CAST(N'2020-07-10T20:17:31.863' AS DateTime), CAST(N'2020-10-10T12:10:13.970' AS DateTime), N'油麦菜的生长周期大概是在40-45天左右。')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (25, N'云南省曲靖市', N'曲靖市蔬菜-萝卜基地', CAST(N'2020-07-10T20:18:33.000' AS DateTime), CAST(N'2020-10-10T12:10:13.970' AS DateTime), N'萝卜生长期根据播种时间的不同，也有所不同。如果夏末时期播种的话，它的生长期在60-100天之内。如果在春末夏初时期播种的话，它的生长期在45-60天之内。')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (26, N'河北省张家口市张北县', N'张北县蔬菜-大白菜生产基地', CAST(N'2020-07-10T20:20:13.030' AS DateTime), CAST(N'2020-10-10T12:10:13.970' AS DateTime), N'大白菜的生长期为55天左右。')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (27, N'河北省张家口市张北县', N'张北县蔬菜-菜花生产基地', CAST(N'2020-07-10T20:20:33.110' AS DateTime), CAST(N'2020-10-10T12:10:13.970' AS DateTime), N'菜花成长周期40-60天。')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (28, N'河北省张家口市张北县', N'张北县蔬菜-卷心菜生产基地', CAST(N'2020-07-10T20:20:58.087' AS DateTime), CAST(N'2020-10-10T12:10:13.970' AS DateTime), N'但各生长时期所需日数较长,发芽期需8 —10天;幼苗期需25—30天;莲座期,早熟品种需20—25天,中、晚熟品种需30—35天;结球期,早熟品种需20—25天,中、晚熟品种需30—50天。')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (29, N'河北省张家口市张北县', N'张北县蔬菜-芹菜生产基地', CAST(N'2020-07-10T20:21:15.993' AS DateTime), CAST(N'2020-10-10T12:10:13.970' AS DateTime), N'芹菜的生长期是三个月左右。')
GO
INSERT [dbo].[T_PlantInfo] ([id], [SeedSource], [PlantFieldNum], [PlantTime], [HarvestTime], [Remark]) VALUES (30, N'河北省张家口市张北县', N'张北县蔬菜-菠菜生产基地', CAST(N'2020-07-10T20:21:36.367' AS DateTime), CAST(N'2020-10-10T12:10:13.970' AS DateTime), N'菠菜的生长期约为30-50天。')
GO
SET IDENTITY_INSERT [dbo].[T_PlantInfo] OFF
GO
SET IDENTITY_INSERT [dbo].[T_ProductionBaseInfo] ON 
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (1, N'云霄东厦水稻种植基地', N'蔬菜', N'Jinx', N'13850526746', N'File/Uploads/云霄东厦水稻种植基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (4, N'888', N'88', N'888', N'88', N'File/Uploads/888.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (5, N'山东省寿光市甜椒种植基地', N'蔬菜-甜椒', N'张三', N'18869872003', N'File/Uploads/山东省寿光市甜椒种植基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (6, N'山东省寿光市辣椒种植基地', N'蔬菜-辣椒', N'张三', N'18869872003', N'File/Uploads/山东省寿光市辣椒种植基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (7, N'山东省寿光市密刺黄瓜种植基地', N'蔬菜-密刺黄瓜', N'张三', N'18869872003', N'File/Uploads/山东省寿光市密刺黄瓜种植基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (8, N'山东省寿光市西瓜种植基地', N'蔬菜-西瓜', N'张三', N'18869872003', N'File/Uploads/山东省寿光市西瓜种植基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (9, N'藤县塘步镇禤洲蔬菜-茄子示范基地', N'蔬菜-茄子', N'李四', N'19983026551', N'File/Uploads/藤县塘步镇禤洲蔬菜-茄子示范基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (10, N'藤县塘步镇禤洲蔬菜-芹菜示范基地', N'蔬菜-芹菜', N'李四', N'19983026551', N'File/Uploads/藤县塘步镇禤洲蔬菜-芹菜示范基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (11, N'云南元谋番茄反季节菜生产基地', N'蔬菜-番茄', N'王五', N'13985693011', N'File/Uploads/云南元谋番茄反季节菜生产基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (12, N'云南元谋圆葱反季节菜生产基地', N'蔬菜-圆葱', N'王五', N'13985693011', N'File/Uploads/云南元谋圆葱反季节菜生产基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (13, N'云南元谋香葱反季节菜生产基地', N'蔬菜-香葱', N'王五', N'13985693011', N'File/Uploads/云南元谋香葱反季节菜生产基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (14, N'云南元谋菜豆反季节菜生产基地', N'蔬菜-菜豆', N'王五', N'13985693011', N'File/Uploads/云南元谋菜豆反季节菜生产基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (15, N'云南元谋牛蒡反季节菜生产基地', N'蔬菜-牛蒡', N'王五', N'13985693011', N'File/Uploads/云南元谋牛蒡反季节菜生产基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (16, N'广东湛江徐闻县蔬菜-豆角基地', N'蔬菜-豆角', N'赵六', N'19936523662', N'File/Uploads/广东湛江徐闻县蔬菜-豆角基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (17, N'广东湛江徐闻县蔬菜-苦瓜基地', N'蔬菜-苦瓜', N'赵六', N'19936523662', N'File/Uploads/广东湛江徐闻县蔬菜-苦瓜基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (18, N'广东湛江徐闻县蔬菜-黄瓜基地', N'蔬菜-黄瓜', N'赵六', N'19936523662', N'File/Uploads/广东湛江徐闻县蔬菜-黄瓜基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (19, N'广东湛江徐闻县蔬菜-辣椒基地', N'蔬菜-辣椒', N'赵六', N'19936523662', N'File/Uploads/广东湛江徐闻县蔬菜-辣椒基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (20, N'广东湛江徐闻县蔬菜-玉米基地', N'蔬菜-玉米', N'赵六', N'19936523662', N'File/Uploads/广东湛江徐闻县蔬菜-玉米基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (21, N'广东湛江徐闻县蔬菜-花生基地', N'蔬菜-花生', N'赵六', N'19936523662', N'File/Uploads/广东湛江徐闻县蔬菜-花生基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (22, N'曲靖市蔬菜-南瓜基地', N'蔬菜-南瓜', N'赵六', N'19936523662', N'File/Uploads/曲靖市蔬菜-南瓜基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (23, N'曲靖市蔬菜-蒜基地', N'蔬菜-蒜', N'赵六', N'19936523662', N'File/Uploads/曲靖市蔬菜-蒜基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (24, N'曲靖市蔬菜-油麦菜基地', N'蔬菜-油麦菜', N'赵六', N'19936523662', N'File/Uploads/曲靖市蔬菜-油麦菜基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (25, N'曲靖市蔬菜-萝卜基地', N'蔬菜-萝卜', N'赵六', N'19936523662', N'File/Uploads/曲靖市蔬菜-萝卜基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (26, N'张北县蔬菜-大白菜生产基地', N'蔬菜-大白菜', N'王天', N'18879852336', N'File/Uploads/张北县蔬菜-大白菜生产基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (27, N'张北县蔬菜-菜花生产基地', N'蔬菜-菜花', N'王天', N'18879852336', N'File/Uploads/张北县蔬菜-菜花生产基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (28, N'张北县蔬菜-卷心菜生产基地', N'蔬菜-卷心菜', N'王天', N'18879852336', N'File/Uploads/张北县蔬菜-卷心菜生产基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (29, N'张北县蔬菜-芹菜生产基地', N'蔬菜-芹菜', N'王天', N'18879852336', N'File/Uploads/张北县蔬菜-芹菜生产基地.jpg')
GO
INSERT [dbo].[T_ProductionBaseInfo] ([id], [Name], [Category], [ResponsibleName], [Telephone], [Image]) VALUES (30, N'张北县蔬菜-菠菜生产基地', N'蔬菜-菠菜', N'王天', N'18879852336', N'File/Uploads/张北县蔬菜-菠菜生产基地.jpg')
GO
SET IDENTITY_INSERT [dbo].[T_ProductionBaseInfo] OFF
GO
SET IDENTITY_INSERT [dbo].[T_ProductionBaseStaff] ON 
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (1, N'彭震川', N'15856040835', N'云霄东厦水稻种植基地', N'File/Uploads/彭震川.png', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (2, N'孙应吉', N'13902790108', N'云霄东厦水稻种植基地', N'File/Uploads/孙应吉.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (3, N'孙顺达', N'13902701832', N'云霄东厦水稻种植基地', N'File/Uploads/孙顺达.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (4, N'李秉贵', N'13902701832', N'云霄东厦水稻种植基地', N'File/Uploads/李秉贵.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (5, N'李厚福', N'13113141314', N'云霄东厦水稻种植基地', N'File/Uploads/李厚福.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (6, N'李开富', N' 13693357480 ', N'云霄东厦水稻种植基地', N'File/Uploads/李开富.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (7, N'王子久', N' 15713939555 ', N'云南元谋反季节菜生产基地', N'File/Uploads/王子久.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (8, N'刘永生', N'18236066456', N'云南元谋反季节菜生产基地', N'File/Uploads/刘永生.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (9, N'刘宝瑞', N'18239367654', N'云南元谋反季节菜生产基地', N'File/Uploads/刘宝瑞.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (10, N'关玉和', N'15868807180', N'云南元谋反季节菜生产基地', N'File/Uploads/关玉和.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (11, N'王仁兴', N'15971345672', N'云南元谋反季节菜生产基地', N'File/Uploads/王仁兴.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (12, N'李际泰', N'15971345672', N'云南元谋反季节菜生产基地', N'File/Uploads/李际泰.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (13, N'罗元发', N'18871345672', N'云南元谋反季节菜生产基地', N'File/Uploads/罗元发.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (14, N'刘造时', N'18871345672', N'云南元谋反季节菜生产基地', N'File/Uploads/刘造时.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (15, N'刘乃超', N'18871345672', N'藤县塘步镇禤洲蔬菜示范基地', N'File/Uploads/刘乃超.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (16, N'刘长胜', N'13271345672', N'藤县塘步镇禤洲蔬菜示范基地', N'File/Uploads/刘长胜.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (17, N'张成基', N'18971345672', N'藤县塘步镇禤洲蔬菜示范基地', N'File/Uploads/张成基.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (18, N'张国柱', N'18971345689', N'藤县塘步镇禤洲蔬菜示范基地', N'File/Uploads/张国柱.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (19, N'张志远', N'13371345689', N'藤县塘步镇禤洲蔬菜示范基地', N'File/Uploads/张志远.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (20, N'张广才', N'13871345689', N'藤县塘步镇禤洲蔬菜示范基地', N'File/Uploads/张广才.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (21, N'吕德榜', N'18871345689', N'藤县塘步镇禤洲蔬菜示范基地', N'File/Uploads/吕德榜.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (22, N'吕文达', N'13871345689', N'曲靖市蔬菜基地', N'File/Uploads/吕文达.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (23, N'吴家栋', N'13971345689', N'曲靖市蔬菜基地', N'File/Uploads/吴家栋.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (24, N'吴国梁', N'18371345689', N'曲靖市蔬菜基地', N'File/Uploads/吴国梁.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (25, N'吴立功', N'12371345689', N'曲靖市蔬菜基地', N'File/Uploads/吴立功.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (26, N'李大江', N'13931345689', N'曲靖市蔬菜基地', N'File/Uploads/李大江.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (27, N'张石山', N'13931345689', N'曲靖市蔬菜基地', N'File/Uploads/张石山.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (28, N'王海', N'13931345689', N'曲靖市蔬菜基地', N'File/Uploads/王海.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (29, N'曹春芳', N'13931345689', N'曲靖市蔬菜基地', N'File/Uploads/曹春芳.jpg', N'普通员工')
GO
INSERT [dbo].[T_ProductionBaseStaff] ([id], [StaffName], [Telephone], [ProductionBaseName], [Image], [Position]) VALUES (30, N'曹珊珊', N'19931345689', N'曲靖市蔬菜基地', N'File/Uploads/曹珊珊.jpg', N'普通员工')
GO
SET IDENTITY_INSERT [dbo].[T_ProductionBaseStaff] OFF
GO
SET IDENTITY_INSERT [dbo].[T_ProductNumInfo] ON 
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (2, N'666', N'666', N'666', N'666', N'File/Uploads/666.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (3, N'01', N'黄瓜', N'山东省寿光市密刺黄瓜种植基地', N'东山仓库', N'File/Uploads/黄瓜.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (4, N'02', N'芹菜', N'张北县蔬菜生产基地', N'东山仓库', N'File/Uploads/芹菜.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (5, N'03', N'上海青', N'张北县蔬菜生产基地', N'东山仓库', N'File/Uploads/上海青.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (6, N'04', N'白菜', N'张北县蔬菜生产基地', N'东山仓库', N'File/Uploads/白菜.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (7, N'05', N'包菜', N'张北县蔬菜生产基地', N'东山仓库', N'File/Uploads/包菜.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (8, N'06', N'番茄', N'张北县蔬菜生产基地', N'东山仓库', N'File/Uploads/番茄.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (9, N'07', N'丝瓜', N'张北县蔬菜生产基地', N'东山仓库', N'File/Uploads/丝瓜.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (10, N'08', N'西瓜', N'张北县蔬菜生产基地', N'东山仓库', N'File/Uploads/西瓜.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (11, N'09', N'草莓', N'张北县蔬菜生产基地', N'东山仓库', N'File/Uploads/草莓.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (12, N'10', N'秋葵', N'张北县蔬菜生产基地', N'东山仓库', N'File/Uploads/秋葵.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (13, N'11', N'辣椒', N'张北县蔬菜生产基地', N'东山仓库', N'File/Uploads/辣椒.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (14, N'12', N'苹果', N'曲靖市蔬菜基地', N'龙海蔬菜仓库', N'File/Uploads/苹果.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (15, N'13', N'洋葱', N'曲靖市蔬菜基地', N'龙海蔬菜仓库', N'File/Uploads/洋葱.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (16, N'14', N'竹笋', N'曲靖市蔬菜基地', N'龙海蔬菜仓库', N'File/Uploads/竹笋.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (17, N'15', N'大蒜', N'曲靖市蔬菜基地', N'龙海蔬菜仓库', N'File/Uploads/大蒜.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (18, N'16', N'彩椒', N'曲靖市蔬菜基地', N'龙海蔬菜仓库', N'File/Uploads/彩椒.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (19, N'17', N'青椒', N'曲靖市蔬菜基地', N'龙海蔬菜仓库', N'File/Uploads/青椒.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (20, N'18', N'苦瓜', N'曲靖市蔬菜基地', N'龙海蔬菜仓库', N'File/Uploads/苦瓜.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (21, N'19', N'胡萝卜', N'曲靖市蔬菜基地', N'龙海蔬菜仓库', N'File/Uploads/胡萝卜.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (22, N'20', N'西兰花', N'曲靖市蔬菜基地', N'龙海蔬菜仓库', N'File/Uploads/西兰花.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (23, N'21', N'羊肉', N'宁德市肉类养殖场', N'福州综合仓库', N'File/Uploads/羊肉.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (24, N'22', N'猪肉', N'宁德市肉类养殖场', N'福州综合仓库', N'File/Uploads/猪肉.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (25, N'23', N'牛肉', N'宁德市肉类养殖场', N'福州综合仓库', N'File/Uploads/牛肉.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (26, N'24', N'鸡肉', N'宁德市肉类养殖场', N'福州综合仓库', N'File/Uploads/鸡肉.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (27, N'25', N'鸭肉', N'宁德市肉类养殖场', N'福州综合仓库', N'File/Uploads/鸭肉.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (28, N'26', N'猕猴桃', N'宁德市水果种植基地', N'福州综合仓库', N'File/Uploads/猕猴桃.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (29, N'27', N'香蕉', N'宁德市水果种植基地', N'福州综合仓库', N'File/Uploads/香蕉.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (30, N'28', N'草莓', N'宁德市水果种植基地', N'福州综合仓库', N'File/Uploads/草莓.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (31, N'29', N'哈密瓜', N'宁德市水果种植基地', N'福州综合仓库', N'File/Uploads/哈密瓜.jpg')
GO
INSERT [dbo].[T_ProductNumInfo] ([id], [ProductNumber], [ProductInfo], [ProductionBase], [WareHouse], [Image]) VALUES (32, N'30', N'橙子', N'宁德市水果种植基地', N'福州综合仓库', N'File/Uploads/橙子.jpg')
GO
SET IDENTITY_INSERT [dbo].[T_ProductNumInfo] OFF
GO
SET IDENTITY_INSERT [dbo].[T_TransportationCompanyInfo] ON 
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (1, N'云霄张二三长途货运有限公司', N'福建省漳州市云霄县', N'张三三', N'14568678423')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (2, N'云霄九九九长途冷冻货运有限公司', N'福建省漳州市云霄县', N'王玖', N'13869522417')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (3, N'天天快送运输有限公司', N'福建省宁德市蕉城区', N'赵天天', N'13369852003')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (4, N'日日快送运输有限公司', N'福建省宁德市蕉城区', N'赵日日', N'18869852003')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (5, N'念余快送运输有限公司', N'福建省宁德市蕉城区', N'赵念余', N'13769852003')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (6, N'膳食快送运输有限公司', N'福建省宁德市蕉城区', N'王涛', N'13852852003')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (7, N'一二三快送运输有限公司', N'福建省宁德市蕉城区', N'王余', N'19936852003')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (8, N'五五无快送运输有限公司', N'福建省宁德市蕉城区', N'王二', N'14436852003')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (9, N'七七无快送运输有限公司', N'福建省宁德市蕉城区', N'王七', N'19936852003')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (10, N'九九无快送运输有限公司', N'福建省宁德市蕉城区', N'王九九', N'18836852003')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (11, N'四十无快送运输有限公司', N'福建省宁德市蕉城区', N'徐六', N'18836852003')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (12, N'天地无快送运输有限公司', N'福建省宁德市蕉城区', N'徐天', N'19936520332')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (13, N'四三九九快送运输有限公司', N'福建省宁德市蕉城区', N'徐四', N'18836520332')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (14, N'六六大顺快送运输有限公司', N'福建省宁德市蕉城区', N'徐六六', N'18936520332')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (15, N'五福临门快送运输有限公司', N'福建省宁德市蕉城区', N'五福', N'18936520332')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (16, N'七上八下快送运输有限公司', N'福建省宁德市蕉城区', N'八下', N'18836520332')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (17, N'弗里曼快送运输有限公司', N'福建省宁德市蕉城区', N'弗里曼', N'13336520332')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (18, N'七里香快送运输有限公司', N'福建省宁德市蕉城区', N'七里香', N'13836520332')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (19, N'魃里香快送运输有限公司', N'福建省宁德市蕉城区', N'魃', N'19836520332')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (20, N'九十快送运输有限公司', N'福建省宁德市蕉城区', N'九', N'19836520332')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (21, N'七七啥快送运输有限公司', N'福建省宁德市蕉城区', N'七七', N'17730659886')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (22, N'下山啥快送运输有限公司', N'福建省宁德市蕉城区', N'买菜', N'18730659886')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (23, N'共工啥快送运输有限公司', N'福建省宁德市蕉城区', N'共工', N'18830659886')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (24, N'祝融快送运输有限公司', N'福建省宁德市蕉城区', N'祝融', N'18930659886')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (25, N'芜湖快送运输有限公司', N'福建省宁德市蕉城区', N'张毅', N'13930659886')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (26, N'善欢快送运输有限公司', N'福建省宁德市蕉城区', N'呐喊', N'13930659886')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (27, N'一九九八快送运输有限公司', N'福建省宁德市蕉城区', N'九八', N'19830659886')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (28, N'一九九七快送运输有限公司', N'福建省宁德市蕉城区', N'九七', N'18830659886')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (29, N'风顺快送运输有限公司', N'福建省宁德市蕉城区', N'顺丰', N'18830659886')
GO
INSERT [dbo].[T_TransportationCompanyInfo] ([id], [Name], [Address], [ResponsibleName], [Telephone]) VALUES (30, N'通员快送运输有限公司', N'福建省宁德市蕉城区', N'元', N'18830659886')
GO
SET IDENTITY_INSERT [dbo].[T_TransportationCompanyInfo] OFF
GO
SET IDENTITY_INSERT [dbo].[T_TransportationEnvironmentInfo] ON 
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (1, N'蔬菜', N'kk', N'18544566332', CAST(N'2020-07-09T00:00:00.000' AS DateTime), 23, 34, N'1')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (2, N'肉类', N'张玉', N'18836521447', CAST(N'2020-07-10T13:23:19.707' AS DateTime), 25, 24, N'2')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (3, N'肉类', N'张西', N'18836521447', CAST(N'2020-07-10T13:23:19.707' AS DateTime), 25, 24, N'3')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (4, N'肉类', N'张九', N'18836521447', CAST(N'2020-07-10T13:23:19.707' AS DateTime), 25, 24, N'4')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (5, N'肉类', N'张市', N'18836521447', CAST(N'2020-07-10T13:23:19.707' AS DateTime), 25, 24, N'5')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (6, N'蔬菜', N'张六', N'18836521447', CAST(N'2020-07-10T13:23:19.707' AS DateTime), 25, 24, N'6')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (7, N'蔬菜', N'吴五', N'18865478552', CAST(N'2020-07-10T13:23:19.707' AS DateTime), 25, 24, N'7')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (8, N'蔬菜', N'吴五', N'18865478552', CAST(N'2020-07-11T13:23:19.707' AS DateTime), 25, 24, N'7')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (9, N'蔬菜', N'赵七', N'18865478552', CAST(N'2020-07-11T13:23:19.707' AS DateTime), 25, 24, N'8')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (10, N'蔬菜', N'赵一', N'18865478552', CAST(N'2020-07-11T13:23:19.707' AS DateTime), 25, 24, N'9')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (11, N'蔬菜', N'赵二', N'18865478552', CAST(N'2020-07-11T13:23:19.707' AS DateTime), 25, 24, N'10')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (12, N'蔬菜', N'赵三', N'18865478552', CAST(N'2020-07-11T13:23:19.707' AS DateTime), 25, 24, N'11')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (13, N'海鲜', N'赵四', N'18865478552', CAST(N'2020-07-11T13:23:19.707' AS DateTime), 25, 24, N'12')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (14, N'海鲜', N'王一', N'18865478552', CAST(N'2020-07-11T13:23:19.707' AS DateTime), 25, 24, N'13')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (15, N'海鲜', N'王二', N'18865478552', CAST(N'2020-07-11T13:23:19.707' AS DateTime), 25, 24, N'14')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (16, N'海鲜', N'王三', N'18865478552', CAST(N'2020-07-11T13:23:19.707' AS DateTime), 25, 24, N'15')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (17, N'海鲜', N'王四', N'18865478552', CAST(N'2020-07-11T13:23:19.707' AS DateTime), 25, 24, N'16')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (18, N'蔬菜', N'王五', N'18865478552', CAST(N'2020-07-11T13:23:19.707' AS DateTime), 25, 24, N'17')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (19, N'蔬菜', N'彭一', N'18865478552', CAST(N'2020-07-11T13:23:19.707' AS DateTime), 25, 24, N'18')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (20, N'蔬菜', N'彭二', N'18865478552', CAST(N'2020-07-12T13:23:19.707' AS DateTime), 20, 20, N'19')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (21, N'蔬菜', N'彭三', N'18865478552', CAST(N'2020-07-12T13:23:19.707' AS DateTime), 20, 20, N'20')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (22, N'蔬菜', N'彭四', N'18865478552', CAST(N'2020-07-12T13:23:19.707' AS DateTime), 20, 20, N'21')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (23, N'蔬菜', N'彭五', N'18865478552', CAST(N'2020-07-12T13:23:19.707' AS DateTime), 20, 20, N'22')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (24, N'调料', N'徐一', N'18865478552', CAST(N'2020-07-12T13:23:19.707' AS DateTime), 20, 20, N'23')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (25, N'蔬菜', N'陈一', N'13860236112', CAST(N'2020-06-10T13:29:45.367' AS DateTime), 21, 22, N'24')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (26, N'蔬菜', N'陈二', N'13860236112', CAST(N'2020-06-10T13:29:45.367' AS DateTime), 21, 22, N'25')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (27, N'蔬菜', N'陈三', N'13860236112', CAST(N'2020-06-10T13:29:45.367' AS DateTime), 21, 22, N'26')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (28, N'蔬菜', N'陈四', N'13860236112', CAST(N'2020-06-10T13:29:45.367' AS DateTime), 21, 22, N'27')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (29, N'蔬菜', N'陈五', N'13860236112', CAST(N'2020-06-10T13:29:45.367' AS DateTime), 21, 22, N'28')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (30, N'蔬菜', N'陈六', N'13860236112', CAST(N'2020-06-10T13:29:45.367' AS DateTime), 21, 22, N'29')
GO
INSERT [dbo].[T_TransportationEnvironmentInfo] ([id], [Plate], [Driver], [Telephone], [DateTime], [Temperature], [Humidity], [ProductNumber]) VALUES (31, N'蔬菜', N'吴一', N'13860236112', CAST(N'2020-06-10T13:29:45.367' AS DateTime), 21, 22, N'30')
GO
SET IDENTITY_INSERT [dbo].[T_TransportationEnvironmentInfo] OFF
GO
SET IDENTITY_INSERT [dbo].[T_TransportCompanyStaff] ON 
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (1, N'wjx', N'13855555555', N'漳大', N'File/Uploads/wjx.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (2, N'sxl', N'13355555522', N'漳大', N'File/Uploads/sxl.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (3, N'尧秋柔', N'18836541002', N'漳州职业技术学院', N'File/Uploads/尧秋柔.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (4, N'井向南', N'18936541002', N'漳州职业技术学院', N'File/Uploads/井向南.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (5, N'禚鸿信', N'13936541002', N'漳州职业技术学院', N'File/Uploads/禚鸿信.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (6, N'释彦红', N'19950365441', N'漳州职业技术学院', N'File/Uploads/释彦红.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (7, N'斯三春', N'18850365441', N'漳州职业技术学院', N'File/Uploads/斯三春.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (8, N'阚玟丽', N'13950365441', N'漳州职业技术学院', N'File/Uploads/阚玟丽.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (9, N'郯寄南', N'13950366112', N'漳州职业技术学院', N'File/Uploads/郯寄南.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (10, N'冒婉君', N'18856320114', N'漳州职业技术学院', N'File/Uploads/冒婉君.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (11, N'粟蕤', N'19956320114', N'漳州职业技术学院', N'File/Uploads/粟蕤.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (12, N'严芹', N'1396320114', N'漳州职业技术学院', N'File/Uploads/严芹.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (13, N'鱼文石', N'1386320114', N'福州职业技术学院', N'File/Uploads/鱼文石.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (14, N'滑含文', N'19963579875', N'福州职业技术学院', N'File/Uploads/滑含文.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (15, N'洪新竹', N'18863579875', N'福州职业技术学院', N'File/Uploads/洪新竹.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (16, N'公辰君', N'18863579875', N'福州职业技术学院', N'File/Uploads/公辰君.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (17, N'忻泽民', N'13963579875', N'福州职业技术学院', N'File/Uploads/忻泽民.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (18, N'粘沈靖', N'13863579875', N'福州职业技术学院', N'File/Uploads/粘沈靖.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (19, N'范素华', N'19951098732', N'福州职业技术学院', N'File/Uploads/范素华.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (20, N'李蔚然', N'18851098732', N'福州职业技术学院', N'File/Uploads/李蔚然.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (21, N'商琴音', N'13951098732', N'福州职业技术学院', N'File/Uploads/商琴音.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (22, N'校绮兰', N'13851098732', N'福州职业技术学院', N'File/Uploads/校绮兰.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (23, N'彭妙珍', N'13851098732', N'厦门海洋职业技术学院', N'File/Uploads/彭妙珍.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (24, N'徭鸿风', N'18969802365', N'厦门海洋职业技术学院', N'File/Uploads/徭鸿风.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (25, N'宣祺然', N'13969802365', N'厦门海洋职业技术学院', N'File/Uploads/宣祺然.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (26, N'越项明', N'13869802365', N'厦门海洋职业技术学院', N'File/Uploads/越项明.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (27, N'袁依', N'18863956330', N'厦门海洋职业技术学院', N'File/Uploads/袁依.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (28, N'呼柔丽', N'18863956330', N'厦门海洋职业技术学院', N'File/Uploads/呼柔丽.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (29, N'栾子楠', N'13856931552', N'厦门海洋职业技术学院', N'File/Uploads/栾子楠.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (30, N'卿思枫', N'13956931552', N'厦门海洋职业技术学院', N'File/Uploads/卿思枫.jpg')
GO
INSERT [dbo].[T_TransportCompanyStaff] ([id], [StaffName], [Telephone], [TransPortCompanyName], [Image]) VALUES (31, N'熊清华', N'19956931552', N'厦门海洋职业技术学院', N'File/Uploads/熊清华.jpg')
GO
SET IDENTITY_INSERT [dbo].[T_TransportCompanyStaff] OFF
GO
SET IDENTITY_INSERT [dbo].[T_WarehouseInfo] ON 
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (1, N'这是仓库', N'这是一个仓库', N'pzc', N'15856040835', 23, 23, N'这是一个仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (2, N'东山仓库', N'福建省漳州市东山', N'张三', N'16636250001', 25, 25, N'东山超大面积仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (3, N'东山二号仓库', N'福建省漳州市东山', N'张三', N'16636250001', 25, 25, N'东山超大面积仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (4, N'东山三号仓库', N'福建省漳州市东山', N'张三', N'16636250001', 25, 25, N'东山超大面积仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (5, N'东山四号仓库', N'福建省漳州市东山', N'张三', N'16636250001', 25, 25, N'东山超大面积仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (6, N'东山五号仓库', N'福建省漳州市东山', N'张三', N'16636250001', 25, 25, N'东山超大面积仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (7, N'龙海蔬菜仓库', N'福建省漳州市龙海区', N'李四', N'18850369851', 27, 26, N'蔬菜专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (8, N'龙海蔬菜二号仓库', N'福建省漳州市龙海区', N'李四', N'18850369851', 27, 26, N'蔬菜专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (9, N'龙海蔬菜三号仓库', N'福建省漳州市龙海区', N'李四', N'18850369851', 27, 26, N'蔬菜专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (10, N'龙海蔬菜四号仓库', N'福建省漳州市龙海区', N'李四', N'18850369851', 27, 26, N'蔬菜专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (11, N'龙海蔬菜五号仓库', N'福建省漳州市龙海区', N'李四', N'18850369851', 27, 26, N'蔬菜专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (12, N'泉州肉类仓库', N'福建省泉州市', N'王五', N'13362032622', 15, 20, N'肉类专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (13, N'泉州肉类二号仓库', N'福建省泉州市', N'王五', N'13362032622', 15, 20, N'肉类专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (14, N'泉州肉类三号仓库', N'福建省泉州市', N'王五', N'13362032622', 15, 20, N'肉类专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (15, N'泉州肉类四号仓库', N'福建省泉州市', N'王五', N'13362032622', 15, 20, N'肉类专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (16, N'泉州肉类五号仓库', N'福建省泉州市', N'王五', N'13362032622', 15, 20, N'肉类专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (17, N'厦门综合仓库', N'福建省厦门', N'赵六', N'18836541002', 20, 20, N'综合型专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (18, N'厦门综合二号仓库', N'福建省厦门', N'赵六', N'18836541002', 20, 20, N'综合型专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (19, N'厦门综合三号仓库', N'福建省厦门', N'赵六', N'18836541002', 20, 20, N'综合型专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (20, N'厦门综合四号仓库', N'福建省厦门', N'赵六', N'18836541002', 20, 20, N'综合型专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (21, N'厦门综合五号仓库', N'福建省厦门', N'赵六', N'18836541002', 20, 20, N'综合型专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (22, N'福州综合仓库', N'福建省福州市', N'田七', N'13926032652', 24, 20, N'综合型专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (23, N'福州综合二仓库', N'福建省福州市', N'田七', N'13926032652', 24, 20, N'综合型专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (24, N'福州综合三仓库', N'福建省福州市', N'田七', N'13926032652', 24, 20, N'综合型专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (25, N'福州综合四仓库', N'福建省福州市', N'田七', N'13926032652', 24, 20, N'综合型专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (26, N'福州综合五仓库', N'福建省福州市', N'田七', N'13926032652', 24, 20, N'综合型专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (27, N'宁德海鲜仓库', N'福建省宁德市', N'李玉', N'13962032661', 20, 20, N'海鲜专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (28, N'宁德海鲜二号仓库', N'福建省宁德市', N'李玉', N'13962032661', 20, 20, N'海鲜专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (29, N'宁德海鲜三号仓库', N'福建省宁德市', N'李玉', N'13962032661', 20, 20, N'海鲜专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (30, N'宁德海鲜四号仓库', N'福建省宁德市', N'李玉', N'13962032661', 20, 20, N'海鲜专属仓库')
GO
INSERT [dbo].[T_WarehouseInfo] ([id], [Name], [Location], [ResponsiblePerson], [Telephone], [Temperature], [Humidity], [Remark]) VALUES (31, N'宁德海鲜五号仓库', N'福建省宁德市', N'李玉', N'13962032661', 20, 20, N'海鲜专属仓库')
GO
SET IDENTITY_INSERT [dbo].[T_WarehouseInfo] OFF
GO
SET IDENTITY_INSERT [dbo].[T_WaterQualityInfo] ON 
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (1, CAST(N'2020-07-09T00:00:00.000' AS DateTime), 7.6, N'良', NULL, NULL)
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (2, CAST(N'2020-07-09T13:29:53.387' AS DateTime), 3.5, N'good', N'kkk', N'File/Uploads/2020-07-09.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (3, CAST(N'2020-07-09T13:44:01.240' AS DateTime), 6.7, N'very good', N'ooo', N'File/Uploads/2020-07-09.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (4, CAST(N'2020-07-09T13:45:16.673' AS DateTime), 7.3, N'biss', N'999', N'File/Uploads/2020-07-09.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (5, CAST(N'2020-07-09T13:46:17.090' AS DateTime), 7.6, N'good', N'888', N'File/Uploads/2020-07-09.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (6, CAST(N'2020-07-10T20:52:30.603' AS DateTime), 7.1, N'good', N'张北县蔬菜生产基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (7, CAST(N'2020-07-10T20:53:06.283' AS DateTime), 7.2, N'good', N'张北县蔬菜生产基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (8, CAST(N'2020-07-10T20:53:12.923' AS DateTime), 6.5, N'good', N'张北县蔬菜生产基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (9, CAST(N'2020-07-10T20:53:19.447' AS DateTime), 5.3, N'good', N'张北县蔬菜生产基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (10, CAST(N'2020-07-10T20:53:23.467' AS DateTime), 4.1, N'good', N'张北县蔬菜生产基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (11, CAST(N'2020-07-10T20:53:26.923' AS DateTime), 3.6, N'good', N'张北县蔬菜生产基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (12, CAST(N'2020-07-10T20:53:50.937' AS DateTime), 5.1, N'good', N'曲靖市蔬菜基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (13, CAST(N'2020-07-10T20:54:07.253' AS DateTime), 9.6, N'good', N'曲靖市蔬菜基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (14, CAST(N'2020-07-10T20:54:11.427' AS DateTime), 7.2, N'good', N'曲靖市蔬菜基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (15, CAST(N'2020-07-10T20:54:13.957' AS DateTime), 4.4, N'good', N'曲靖市蔬菜基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (16, CAST(N'2020-07-10T20:54:16.617' AS DateTime), 5.8, N'good', N'曲靖市蔬菜基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (17, CAST(N'2020-07-10T20:54:20.077' AS DateTime), 6.6, N'good', N'曲靖市蔬菜基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (18, CAST(N'2020-07-10T20:54:52.080' AS DateTime), 3.6, N'good', N'曲靖市蔬菜基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (19, CAST(N'2020-07-10T20:55:29.077' AS DateTime), 7.3, N'very good', N'曲靖市蔬菜基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (20, CAST(N'2020-07-10T20:55:33.387' AS DateTime), 7.4, N'very good', N'曲靖市蔬菜基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (21, CAST(N'2020-07-10T20:55:53.810' AS DateTime), 7.4, N'very good', N'广东湛江徐闻县蔬菜基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (22, CAST(N'2020-07-10T20:55:57.703' AS DateTime), 7.4, N'good', N'广东湛江徐闻县蔬菜基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (23, CAST(N'2020-07-10T20:56:04.160' AS DateTime), 6.3, N'very good', N'广东湛江徐闻县蔬菜基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (24, CAST(N'2020-07-10T20:56:14.683' AS DateTime), 6.4, N'very good', N'广东湛江徐闻县蔬菜基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (25, CAST(N'2020-07-10T20:56:18.493' AS DateTime), 6.5, N'very good', N'广东湛江徐闻县蔬菜基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (26, CAST(N'2020-07-10T20:56:21.590' AS DateTime), 6.6, N'very good', N'广东湛江徐闻县蔬菜基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (27, CAST(N'2020-07-10T20:56:25.187' AS DateTime), 6.7, N'very good', N'广东湛江徐闻县蔬菜基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (28, CAST(N'2020-07-10T20:56:28.840' AS DateTime), 6.8, N'very good', N'广东湛江徐闻县蔬菜基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (29, CAST(N'2020-07-10T20:56:39.213' AS DateTime), 7.1, N'very good', N'广东湛江徐闻县蔬菜基地', N'File/Uploads/2020-07-10.jpg')
GO
INSERT [dbo].[T_WaterQualityInfo] ([id], [DateOfSampling], [PH], [ComprehensiveEvaluation], [Remark], [Image]) VALUES (30, CAST(N'2020-07-10T20:56:44.047' AS DateTime), 7.2, N'very good', N'广东湛江徐闻县蔬菜基地', N'File/Uploads/2020-07-10.jpg')
GO
SET IDENTITY_INSERT [dbo].[T_WaterQualityInfo] OFF
GO
USE [master]
GO
ALTER DATABASE [Traceable] SET  READ_WRITE 
GO
