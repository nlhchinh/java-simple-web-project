USE [master]
GO
/****** Object:  Database [Chinh_FA223W]    Script Date: 02/12/2022 9:42:34 SA ******/
CREATE DATABASE [Chinh_FA223W]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Chinh_FA223W', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Chinh_FA223W.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Chinh_FA223W_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Chinh_FA223W_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Chinh_FA223W] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Chinh_FA223W].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Chinh_FA223W] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Chinh_FA223W] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Chinh_FA223W] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Chinh_FA223W] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Chinh_FA223W] SET ARITHABORT OFF 
GO
ALTER DATABASE [Chinh_FA223W] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Chinh_FA223W] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Chinh_FA223W] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Chinh_FA223W] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Chinh_FA223W] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Chinh_FA223W] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Chinh_FA223W] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Chinh_FA223W] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Chinh_FA223W] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Chinh_FA223W] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Chinh_FA223W] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Chinh_FA223W] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Chinh_FA223W] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Chinh_FA223W] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Chinh_FA223W] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Chinh_FA223W] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Chinh_FA223W] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Chinh_FA223W] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Chinh_FA223W] SET  MULTI_USER 
GO
ALTER DATABASE [Chinh_FA223W] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Chinh_FA223W] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Chinh_FA223W] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Chinh_FA223W] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Chinh_FA223W] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Chinh_FA223W]
GO
/****** Object:  Table [dbo].[tblAccount]    Script Date: 02/12/2022 9:42:34 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblAccount](
	[userID] [nvarchar](50) NOT NULL,
	[lastName] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[role] [nvarchar](50) NULL,
 CONSTRAINT [PK_tblAccount] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[tblAccount] ([userID], [lastName], [password], [role]) VALUES (N'SE140506', N'chinh', N'1', N'AD')
INSERT [dbo].[tblAccount] ([userID], [lastName], [password], [role]) VALUES (N'SE140507', N'trinh', N'1', N'US')
INSERT [dbo].[tblAccount] ([userID], [lastName], [password], [role]) VALUES (N'SE140508', N'tu', N'1', N'AD')
INSERT [dbo].[tblAccount] ([userID], [lastName], [password], [role]) VALUES (N'SE140509', N'tran', N'1', N'US')
INSERT [dbo].[tblAccount] ([userID], [lastName], [password], [role]) VALUES (N'SE140523', N'manh', N'1', N'AD')
INSERT [dbo].[tblAccount] ([userID], [lastName], [password], [role]) VALUES (N'SE140524', N'mai', N'1', N'US')
INSERT [dbo].[tblAccount] ([userID], [lastName], [password], [role]) VALUES (N'SE140525', N'nhi', N'1', N'AD')
INSERT [dbo].[tblAccount] ([userID], [lastName], [password], [role]) VALUES (N'SE140526', N'ha', N'1', N'US')
USE [master]
GO
ALTER DATABASE [Chinh_FA223W] SET  READ_WRITE 
GO
