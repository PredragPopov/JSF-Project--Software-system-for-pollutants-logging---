-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 29, 2015 at 06:20 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `jsfprvadb`
--

-- --------------------------------------------------------

--
-- Table structure for table `firme`
--

CREATE TABLE IF NOT EXISTS `firme` (
  `PIB` varchar(32) NOT NULL,
  `maticni_broj` varchar(32) NOT NULL,
  `naziv` text NOT NULL,
  `delatnost` text NOT NULL,
  `mesto` varchar(64) NOT NULL,
  `sifra_mesta` varchar(64) NOT NULL,
  `postanski_broj` varchar(64) NOT NULL,
  `ulica_broj` varchar(64) NOT NULL,
  `telefon` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL,
  `opstina` varchar(64) NOT NULL,
  `sifra_opstine` varchar(64) NOT NULL,
  `sifra_delatnosti` varchar(64) NOT NULL,
  `arhiviran` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`PIB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `firme`
--

INSERT INTO `firme` (`PIB`, `maticni_broj`, `naziv`, `delatnost`, `mesto`, `sifra_mesta`, `postanski_broj`, `ulica_broj`, `telefon`, `email`, `opstina`, `sifra_opstine`, `sifra_delatnosti`, `arhiviran`) VALUES
('00110022', '00001', 'Atlantic', 'distribucija', 'Simanovci', '011', '11000', 'Blagoja Pantica 12', '011/2323232 ', 'atlanticgrupa@gmail.com', 'Simanovci', '011045', '0023294', 0),
('00110033', '0002', 'Firma2', 'mlekara', 'Beograd', '011', '11000', 'Beogradsa 21', '011/2323232', 'bg@gamil.com', 'promenjeno', '01101', 'xx88x', 0),
('00110044', '0003', 'Firma3', 'xx', 'Beograd', '011', '11000', 'Beogradsa 21', '011/2323232', 'bg@gamil.com', 'promenjeno', '01101', 'xx88x', 1),
('00110055', '0004', 'Nelt', 'dstribucija', 'Budjanovci', '13001', '13001', 'Neznanih junaka 5', '0112323112', 'nelt@gmail,rs', 'Novi sad', '01233', '32112', 0),
('00110066', '023543', 'Marbo', 'prehrana', 'Mirijevo', '11003', '11003', 'Nikole Belog 23', '0112345333', 'marbo@gmail.com', 'Beograd', '11000', '2342', 0),
('00110077', '348885', 'Podravka', 'prehrana', 'Backi jarak', '00402', '13001', 'Niska 23', '0118877665', 'podravka@yahoo.com', 'Sid', '213004', '2315', 1);

-- --------------------------------------------------------

--
-- Table structure for table `korisnici`
--

CREATE TABLE IF NOT EXISTS `korisnici` (
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `arhiviran` tinyint(1) NOT NULL DEFAULT '0',
  `tip_korisnika` enum('referent_firme','referent_registra','administrator') NOT NULL,
  `firma` varchar(32) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `korisnici`
--

INSERT INTO `korisnici` (`username`, `password`, `arhiviran`, `tip_korisnika`, `firma`) VALUES
('admin', 'admin', 0, 'administrator', ''),
('Danilo', 'lozinka', 0, 'referent_firme', '00110055'),
('firma2', 'ddd', 1, 'referent_firme', '00110033'),
('Milan', 'password', 0, 'referent_firme', '00110066'),
('neko', 'Kh73QHAcKz4DKbu', 0, 'referent_firme', ''),
('nesto@gmail.com', 'Zs8S3MrBvPnVHmy', 0, 'referent_firme', '00110022'),
('opstina1', 'pass123', 0, 'referent_registra', ''),
('opstina2', 'pass123', 1, 'referent_registra', ''),
('PeraKojot@gmail.com', '7zJxqVfvytvgrtY', 0, 'referent_firme', ''),
('predrag', 'password', 0, 'referent_firme', '00110022'),
('XXX@gmail.com', 'vCeasteyGqGKH6C', 0, 'referent_firme', '00110022');

-- --------------------------------------------------------

--
-- Table structure for table `materije_tlo`
--

CREATE TABLE IF NOT EXISTS `materije_tlo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_obrazac_4` int(11) NOT NULL,
  `naziv` text NOT NULL,
  `CAS` int(11) NOT NULL,
  `koncetracija` double NOT NULL,
  `nacin_odredjivanja` text NOT NULL,
  `metod_odredjivanja` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `materije_tlo`
--

INSERT INTO `materije_tlo` (`ID`, `ID_obrazac_4`, `naziv`, `CAS`, `koncetracija`, `nacin_odredjivanja`, `metod_odredjivanja`) VALUES
(1, 1, 's1', 123, 123, 'asd', 'asd'),
(2, 1, 'a2', 123, 123, 'asd', 'asd'),
(3, 1, 'a3', 123, 123, 'asd', 'asd'),
(4, 1, 'a5', 123, 123, 'asd', 'asd'),
(7, 7, 'prva', 1, 2, 'nacin', 'metod'),
(8, 7, 'druga', 3, 4, 'nacin', 'metod'),
(9, 3, 'a2', 123, 123, 'asd', 'asd'),
(10, 3, 'a5', 123, 123, 'asd', 'asd'),
(11, 7, 'a2', 123, 123, 'asd', 'asd'),
(12, 3, 'a3', 123, 123, 'asd', 'asd'),
(13, 8, 's1', 123, 123, 'asd', 'asd'),
(14, 8, 'prva', 1, 2, 'nacin', 'metod'),
(15, 8, 'a2', 123, 123, 'asd', 'asd'),
(16, 9, 'a2', 123, 123, 'asd', 'asd'),
(17, 9, 'a2', 123, 123, 'asd', 'asd');

-- --------------------------------------------------------

--
-- Table structure for table `materije_vazduh`
--

CREATE TABLE IF NOT EXISTS `materije_vazduh` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_obrazac_2` int(11) NOT NULL,
  `naziv` text NOT NULL,
  `SGIV` double NOT NULL,
  `EKN` double NOT NULL,
  `EKE` double NOT NULL,
  `nacin_odredjivanja` text NOT NULL,
  `metod_odredjivanja` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=35 ;

--
-- Dumping data for table `materije_vazduh`
--

INSERT INTO `materije_vazduh` (`ID`, `ID_obrazac_2`, `naziv`, `SGIV`, `EKN`, `EKE`, `nacin_odredjivanja`, `metod_odredjivanja`) VALUES
(23, 14, 'H2CK', 23100, 134000, 13, 'procentualno', 'matematicki, teoriski'),
(24, 14, 'J8H9CV', 1234, 8574, 4958, 'nacin 2', 'metod 2'),
(25, 14, 'HJ8IU', 23100, 134000, 13, 'procentualno', 'matematicki, teoriski'),
(26, 15, 'H2CK', 23100, 134000, 13, 'procentualno', 'matematicki, teoriski'),
(27, 15, 'HJ8IU', 23100, 134000, 13, 'procentualno', 'matematicki, teoriski'),
(28, 16, 'S9D43', 1239, 5453, 543, 'necin 3', 'metod 3'),
(29, 16, 'SDF3DF', 0, 12437, 5435, 'nacin 4', 'metod 4'),
(30, 16, 'SDSAD3', 1239, 5453, 543, 'necin 3', 'metod 3'),
(31, 18, 'SDF3DF', 0, 12437, 5435, 'nacin 4', 'metod 4'),
(32, 18, 'SDSAD3', 1239, 5453, 543, 'necin 3', 'metod 3'),
(33, 17, 'HJ7HHD', 243847, 432845, 5325, 'nacin 5', 'metod 5'),
(34, 19, ' JFH79J', 2485, 788, 985439, 'nacin 7', 'metod 7');

-- --------------------------------------------------------

--
-- Table structure for table `materije_vode`
--

CREATE TABLE IF NOT EXISTS `materije_vode` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_obrazac_3` int(11) NOT NULL,
  `naziv` text NOT NULL,
  `CAS` text NOT NULL,
  `SGIV` double NOT NULL,
  `redovne_kol` double NOT NULL,
  `extremne_kol` double NOT NULL,
  `nacin_odredjivanja` text NOT NULL,
  `metod_odredjivanja` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=33 ;

--
-- Dumping data for table `materije_vode`
--

INSERT INTO `materije_vode` (`ID`, `ID_obrazac_3`, `naziv`, `CAS`, `SGIV`, `redovne_kol`, `extremne_kol`, `nacin_odredjivanja`, `metod_odredjivanja`) VALUES
(6, 1, 'voda 5', '55', 5, 5, 5, 'nnn 5', 'mmm 5'),
(12, 5, 'prva materija', '112200', 1, 2, 3, 'nacin1', 'metod1'),
(13, 5, 'druga materija', '112200', 3, 4, 5, 'nacin1', 'metod1'),
(14, 5, 'materija atlantic', '24543', 325245, 234, 4324, 'nacin 1', 'metod 1'),
(15, 5, 'materija atlantic', '3525', 7874, 4784, 44444, 'nacin 2', 'metod 3'),
(16, 6, 'materija atlantic', '24543', 325245, 234, 4324, 'nacin 1', 'metod 1'),
(17, 6, 'materija atlantic', '3525', 7874, 4784, 44444, 'nacin 2', 'metod 3'),
(18, 6, 'materija atlantic', '24543', 325245, 234, 4324, 'nacin 1', 'metod 1'),
(19, 9, 'voda 5', '55', 5, 5, 5, 'nnn 5', 'mmm 5'),
(20, 9, 'materija atlantic', '24543', 325245, 234, 4324, 'nacin 1', 'metod 1'),
(21, 9, 'materija atlantic', '24543', 325245, 234, 4324, 'nacin 1', 'metod 1'),
(22, 10, 'voda 5', '55', 5, 5, 5, 'nnn 5', 'mmm 5'),
(23, 10, 'prva materija', '112200', 1, 2, 3, 'nacin1', 'metod1'),
(24, 11, 'voda 5', '55', 5, 5, 5, 'nnn 5', 'mmm 5'),
(25, 11, 'prva materija', '112200', 1, 2, 3, 'nacin1', 'metod1'),
(26, 11, 'druga materija', '112200', 3, 4, 5, 'nacin1', 'metod1'),
(27, 12, 'materija nelt', '5435', 5435, 34, 333, 'nacin 3', 'metod 3'),
(28, 12, 'materija nelt', '5435', 7483, 43, 90, 'nacin 5', 'metod 5'),
(29, 12, 'materija nelt', '234', 432, 33, 55, 'nacin 6', 'metod 6'),
(30, 13, 'materija nelt', '5435', 5435, 34, 333, 'nacin 3', 'metod 3'),
(31, 13, 'materija nelt', '5435', 7483, 43, 90, 'nacin 5', 'metod 5'),
(32, 13, 'materija nelt', '234', 432, 33, 55, 'nacin 6', 'metod 6');

-- --------------------------------------------------------

--
-- Table structure for table `obrazac_1`
--

CREATE TABLE IF NOT EXISTS `obrazac_1` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PIB` varchar(32) NOT NULL,
  `period` int(11) NOT NULL,
  `predato` tinyint(1) NOT NULL DEFAULT '0',
  `mesto` varchar(32) NOT NULL,
  `opstina` varchar(32) NOT NULL,
  `ol_ime_prezime` varchar(32) NOT NULL,
  `ol_funk` varchar(32) NOT NULL,
  `ol_tel` varchar(32) NOT NULL,
  `k_ime_prezime` varchar(32) NOT NULL,
  `k_funk` varchar(32) NOT NULL,
  `k_tel` varchar(32) NOT NULL,
  `k_email` varchar(128) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `obrazac_1`
--

INSERT INTO `obrazac_1` (`ID`, `PIB`, `period`, `predato`, `mesto`, `opstina`, `ol_ime_prezime`, `ol_funk`, `ol_tel`, `k_ime_prezime`, `k_funk`, `k_tel`, `k_email`) VALUES
(4, '00110055', 2015, 0, 'Dobanovci', 'Beograd', 'Marija Markovic', 'komercijalista', '0641233838', 'Danilo Cvetojevic', 'mrca', '064558857', 'daca@gmail.com'),
(5, '00110055', 2014, 1, 'Dobanovci', 'Beograd', 'Marija Markovic', 'komercijalista', '0645577557', 'Danilo Cvetojevic', 'mrca', '064558869', 'daca@gmail.com'),
(6, '00110022', 2014, 1, 'Simanovci', 'Beograd', 'Pera Peric', 'direktnor', '011234432', 'Mira Markovic', 'sekretar', '0114475848', 'atlantic@gmail.com'),
(7, '00110066', 2014, 1, 'Mirijevo', 'Beograd', 'Paja Gradic', 'direktor', '022395475', 'Milan Gradic', 'mrca ', '064773837', 'mica@gmail.com'),
(9, '00110066', 2016, 1, 'Mirijevo', 'Beograd', 'Paja Gradic', 'direktor', '022395475', 'Milan Gradic', 'mrca ', '064773837', 'mica@gmail.com'),
(11, '00110022', 2015, 0, 'Simanovci', 'Novi Sad', 'Marko Makaric', 'Direktor proizvodnje', '011/2323342', 'Pera Ilic', 'Sekretar proizvodnje', '011/2323112', 'pera@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `obrazac_2`
--

CREATE TABLE IF NOT EXISTS `obrazac_2` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PIB` varchar(32) NOT NULL,
  `period` int(11) NOT NULL,
  `predato` tinyint(1) NOT NULL DEFAULT '0',
  `naziv_izvora` varchar(64) NOT NULL,
  `broj_izvora` int(11) NOT NULL,
  `vrsta_izvora` varchar(64) NOT NULL,
  `nadmorska_visina` double NOT NULL,
  `visina_izvora` double NOT NULL,
  `precnik` double NOT NULL,
  `iskoriscenost` double NOT NULL,
  `toplotna_snaga` double NOT NULL,
  `srednja_god_temp` double NOT NULL,
  `brzina` double NOT NULL,
  `protok` double NOT NULL,
  `rezim_rada` varchar(64) NOT NULL,
  `dana_godisnje` int(11) NOT NULL,
  `sati_dnevno` double NOT NULL,
  `napomena` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=22 ;

--
-- Dumping data for table `obrazac_2`
--

INSERT INTO `obrazac_2` (`ID`, `PIB`, `period`, `predato`, `naziv_izvora`, `broj_izvora`, `vrsta_izvora`, `nadmorska_visina`, `visina_izvora`, `precnik`, `iskoriscenost`, `toplotna_snaga`, `srednja_god_temp`, `brzina`, `protok`, `rezim_rada`, `dana_godisnje`, `sati_dnevno`, `napomena`) VALUES
(12, '00110022', 2016, 1, 'dimljak 1', 1, 'direktno', 20, 20, 2.5, 80, 90, 35, 10, 20, 'stalan', 221, 14, 'napomena'),
(14, '00110022', 2014, 1, 'izvor A', 2, 'dimljak', 120, 20, 1, 50, 220, 36, 110, 23, 'konstantan', 360, 18, ''),
(15, '00110022', 2015, 0, 'izvor A', 2, 'dimljak', 120, 20, 1, 50, 220, 36, 110, 23, 'konstantan', 360, 18, ''),
(16, '00110055', 2014, 1, 'Bjelovici', 1, 'dimljak', 232, 12, 5, 80, 40, 34, 231, 100, 'konstantan', 287, 14, 'spaljivanje velikih kolicina kartona, plastike i pokvarene robe tipa prehrana'),
(17, '00110066', 2014, 1, 'Mirijevo 4', 1, 'dimljak', 145, 23, 2, 50, 234, 34, 231, 234, 'povremen', 190, 8, ''),
(18, '00110055', 2015, 0, 'Bjelovici', 1, 'dimljak', 232, 12, 5, 80, 40, 34, 231, 100, 'konstantan', 287, 14, 'spaljivanje velikih kolicina kartona, plastike i pokvarene robe tipa prehrana'),
(19, '00110066', 2015, 1, 'Mirijevo 4', 1, 'dimljak', 145, 23, 2, 50, 234, 34, 231, 234, 'povremen', 190, 8, ''),
(21, '00110022', 2015, 1, 'izvor A', 2, 'dimljak', 120, 20, 1, 50, 220, 36, 110, 23, 'konstantan', 360, 18, '');

-- --------------------------------------------------------

--
-- Table structure for table `obrazac_3`
--

CREATE TABLE IF NOT EXISTS `obrazac_3` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PIB` varchar(32) NOT NULL,
  `period` int(11) NOT NULL,
  `predato` tinyint(1) NOT NULL DEFAULT '0',
  `naziv_ispusta` text NOT NULL,
  `broj_ispusta` int(11) NOT NULL,
  `rezim_rada` text NOT NULL,
  `kapacitet` double NOT NULL,
  `vremenski_period` text NOT NULL,
  `ukupna_kolicina` double NOT NULL,
  `mehanicko` text NOT NULL,
  `hemisko` text NOT NULL,
  `biolosko` text NOT NULL,
  `izmena_toplote` text NOT NULL,
  `napomena` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `obrazac_3`
--

INSERT INTO `obrazac_3` (`ID`, `PIB`, `period`, `predato`, `naziv_ispusta`, `broj_ispusta`, `rezim_rada`, `kapacitet`, `vremenski_period`, `ukupna_kolicina`, `mehanicko`, `hemisko`, `biolosko`, `izmena_toplote`, `napomena`) VALUES
(5, '00110022', 2016, 0, 'Boljevac 1', 2, 'kontinualan', 3411, '08 - 20', 23100, 'pesak', 'H3FG8H9', 'nema', 'Stela 2CF', 'napomena'),
(6, '00110022', 2015, 0, 'Boljevac 2', 3, 'kontinualan', 3411, '08 - 20', 23100, 'pesak', 'H3FG8H9', 'nema', 'Stela 2CF', 'napomena'),
(9, '00110022', 2014, 1, 'Boljevac 2', 3, 'kontinualan', 3411, '08 - 20', 23100, 'pesak', 'H3FG8H9', 'nema', 'Stela 2CF', 'napomena'),
(10, '00110022', 2014, 1, 'Boljevac 3', 3, 'kontinualan', 3411, '08 - 20', 23100, 'pesak', 'H3FG8H9', 'nema', 'Stela 2CF', 'napomena'),
(11, '00110022', 2014, 1, 'Boljevac 1', 3, 'kontinualan', 3411, '08 - 20', 23100, 'pesak', 'H3FG8H9', 'nema', 'Stela 2CF', 'napomena'),
(12, '00110055', 2014, 1, 'ispust sever', 1, 'periodican', 23189, '07.00 / 19.00', 325345, 'nema', 'H2OJK3J', 'pacovi', 'ne', ''),
(13, '00110055', 2015, 0, 'ispust sever', 1, 'periodican', 23189, '07.00 / 19.00', 325345, 'nema', 'H2OJK3J', 'pacovi', 'ne', '');

-- --------------------------------------------------------

--
-- Table structure for table `obrazac_4`
--

CREATE TABLE IF NOT EXISTS `obrazac_4` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PIB` varchar(32) NOT NULL,
  `period` int(11) NOT NULL,
  `predato` tinyint(1) NOT NULL DEFAULT '0',
  `naziv_lokacije` text NOT NULL,
  `vrsta_otpada` text NOT NULL,
  `kolicina_godisnje` double NOT NULL,
  `nacin_odlaganja` text NOT NULL,
  `napomena` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `obrazac_4`
--

INSERT INTO `obrazac_4` (`ID`, `PIB`, `period`, `predato`, `naziv_lokacije`, `vrsta_otpada`, `kolicina_godisnje`, `nacin_odlaganja`, `napomena`) VALUES
(1, '00110022', 2015, 0, 'lokacija 1', 'asd', 1, 'asd', 'asd'),
(3, '00110022', 2014, 1, 'lokacija 3', '231', 2, 'af', 'asf'),
(4, '00110033', 2015, 0, 'lokacija 4', 'sda', 3, 'asd', 'asd'),
(7, '00110022', 2016, 0, 'Simanovci', 'cvrst otpad', 20100, 'presovane kocke kartona', 'promena'),
(8, '00110066', 2014, 1, 'mirijevo G7', 'karton', 3414, 'nacin 2', 'metod 2'),
(9, '00110066', 2015, 1, 'mirijevo G7', 'karton', 3414, 'nacin 2', 'metod 2');

-- --------------------------------------------------------

--
-- Table structure for table `obrazac_5`
--

CREATE TABLE IF NOT EXISTS `obrazac_5` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PIB` varchar(32) NOT NULL,
  `period` int(11) NOT NULL,
  `predato` tinyint(1) NOT NULL DEFAULT '0',
  `mesto_nastanka` text NOT NULL,
  `naziv` text NOT NULL,
  `vrsta` text NOT NULL,
  `opis` text NOT NULL,
  `kategorija` text NOT NULL,
  `karakter` text NOT NULL,
  `izvestaj_broj` int(11) NOT NULL,
  `izvestaj_datum` varchar(32) NOT NULL,
  `fizicko_stanje` text NOT NULL,
  `transport` text NOT NULL,
  `odrediste` text NOT NULL,
  `napomena` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `obrazac_5`
--

INSERT INTO `obrazac_5` (`ID`, `PIB`, `period`, `predato`, `mesto_nastanka`, `naziv`, `vrsta`, `opis`, `kategorija`, `karakter`, `izvestaj_broj`, `izvestaj_datum`, `fizicko_stanje`, `transport`, `odrediste`, `napomena`) VALUES
(8, '00110022', 2014, 1, 'Simanovci ', 'otpad atlantic', 'sekundarne sirovine', 'karton, plastika, staklo', 'druga', 'slabo degradivni', 239584, '11.03.2014', 'cvrsto', 'sleper', 'smetliste Backi jarak', ''),
(9, '00110055', 2014, 1, 'Dobanovci', 'otpad Nelt', 'sekundarne sirovine', 'organski otpad i karton', 'treca', 'slabo degradivni', 238584, '01.02.2014', 'tecno', 'cisterne Jakovljevic', 'Subotica', ''),
(10, '00110022', 2015, 0, 'Simanovci ', 'otpad atlantic', 'sekundarne sirovine', 'karton, plastika, staklo', 'druga', 'slabo degradivni', 239584, '11.03.2015', 'cvrsto', 'sleper', 'smetliste Backi jarak', ''),
(11, '00110055', 2015, 0, 'Dobanovci', 'otpad Nelt', 'sekundarne sirovine', 'organski otpad i karton', 'treca', 'slabo degradivni', 238584, '01.02.2015', 'tecno', 'cisterne Jakovljevic', 'Subotica', ''),
(12, '00110066', 2014, 1, 'Mirijevo', 'otpad Marbo', 'karton', 'karton, celofan', 'druga', 'defanzivan', 24848, '03.04.2014', 'cvrsto', 'kamioni Pera Detlic', 'Kotez', ''),
(13, '00110066', 2015, 0, 'Mirijevo', 'otpad Marbo', 'karton', 'karton, celofan', 'druga', 'defanzivan', 24848, '03.04.2014', 'cvrsto', 'kamioni Pera Detlic', 'Kotez', '');

-- --------------------------------------------------------

--
-- Table structure for table `period`
--

CREATE TABLE IF NOT EXISTS `period` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `godina` int(11) NOT NULL,
  `zakljucan` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `period`
--

INSERT INTO `period` (`ID`, `godina`, `zakljucan`) VALUES
(2, 2014, 1),
(3, 2015, 0),
(6, 2016, 0);

-- --------------------------------------------------------

--
-- Table structure for table `sifarnici`
--

CREATE TABLE IF NOT EXISTS `sifarnici` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `sifarnici`
--

INSERT INTO `sifarnici` (`ID`, `naziv`) VALUES
(5, 'sifarnik delatnosti'),
(6, 'sifarnik zagadjujucih materija');

-- --------------------------------------------------------

--
-- Table structure for table `sifre`
--

CREATE TABLE IF NOT EXISTS `sifre` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_sifarnika` int(11) NOT NULL,
  `sifra` text NOT NULL,
  `naziv` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `sifre`
--

INSERT INTO `sifre` (`ID`, `ID_sifarnika`, `sifra`, `naziv`) VALUES
(1, 5, '112323', 'nesto 1'),
(2, 5, '654g45y', 'nesto 2'),
(3, 6, '5435k5', 'nesto 4'),
(4, 6, '2314rewt3', 'nesto 5'),
(5, 5, '124rew3', 'nesto 7'),
(6, 6, '34234trter4', 'nesto 11');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
