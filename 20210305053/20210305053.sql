-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 06 May 2024, 22:21:52
-- Sunucu sürümü: 10.4.32-MariaDB
-- PHP Sürümü: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `20210305053`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `category` varchar(50) NOT NULL,
  `item` varchar(50) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `admin`
--

INSERT INTO `admin` (`id`, `category`, `item`, `price`) VALUES
(2, 'Beyaz Eşya', 'Buzdolabı', 25000),
(3, 'Beyaz Eşya', 'Koltuk Takımı', 7000),
(4, 'Erkek Giyim', 'Pantolon', 500),
(5, 'Erkek Giyim', 'Ceket', 800),
(6, 'Oyun', 'Oyuncu Bilgisayarı', 3000);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `customerlogin`
--

CREATE TABLE `customerlogin` (
  `id` int(255) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `customerlogin`
--

INSERT INTO `customerlogin` (`id`, `email`, `password`) VALUES
(1, 'bekir@123', 123123),
(2, 'ali123@hotmail.com', 159753),
(3, 'muhammed@hotmail.com', 123321),
(4, 'sergen@hotmail.com', 798321),
(5, 'furkan@hotmail.com', 22124),
(6, 'mehmet_321@hotmail.com', 123321),
(7, 'burak10@hotmail.com', 4532456),
(8, 'cengiz123@hotmail.com', 12345);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `customerorder`
--

CREATE TABLE `customerorder` (
  `id` int(255) NOT NULL,
  `name` varchar(25) NOT NULL,
  `surname` varchar(25) NOT NULL,
  `address` varchar(50) NOT NULL,
  `item` varchar(50) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `customerorder`
--

INSERT INTO `customerorder` (`id`, `name`, `surname`, `address`, `item`, `price`) VALUES
(1, 'Bekir', 'Yavuz', 'İstanbul-Ataşehir', 'Bilgisayar', 15000),
(2, 'Cengiz', 'Yavuz', 'İstanbul-Ataşehir', 'Çamaşır Makinesi', 5000),
(3, 'Ali', 'Kağan', 'İstanbul-Tuzla', 'Çanta', 300),
(4, 'Muhammet', 'Mustafa', 'İstanbul-Malpete', 'Oyun Konsolu', 4000),
(5, 'Mehmet', 'Çetin', 'İstanbul-Göztepe', 'Televizyon', 10000);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `customerpurchase`
--

CREATE TABLE `customerpurchase` (
  `id` int(255) NOT NULL,
  `creditcard` int(11) NOT NULL,
  `customerorderid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `customerpurchase`
--

INSERT INTO `customerpurchase` (`id`, `creditcard`, `customerorderid`) VALUES
(1, 2147483647, 1),
(2, 2147483647, 2),
(3, 2147483647, 3),
(4, 2147483647, 4),
(5, 2147483647, 5);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `customerregistration`
--

CREATE TABLE `customerregistration` (
  `id` int(255) NOT NULL,
  `name` varchar(25) NOT NULL,
  `surname` varchar(25) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `customerregistration`
--

INSERT INTO `customerregistration` (`id`, `name`, `surname`, `email`, `password`) VALUES
(1, 'Bekir', 'Yavuz', 'bekir@123', 1234),
(2, 'Cengiz', 'Yavuz', 'cengiz123@hotmail.com', 12345),
(3, 'Ali', 'Kağan', 'ali123@hotmail.com', 159753),
(4, 'Muhammet', 'Mustafa', 'muhammed@hotmail.com', 123321),
(5, 'Sergen', 'Yavuz', 'sergen@hotmail.com', 798321),
(6, 'Furkan', 'Yavuz', 'furkan@hotmail.com', 22124),
(7, 'Mehmet', 'Çetin', 'mehmet_321@hotmail.com', 123321),
(8, 'Burak', 'Can', 'burak10@hotmail.com', 4532456);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `items`
--

CREATE TABLE `items` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` int(25) NOT NULL,
  `brand` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `items`
--

INSERT INTO `items` (`id`, `name`, `price`, `brand`) VALUES
(1, 'Bilgisayar', 15000, 'xs'),
(2, 'Kulaklık', 600, 'SL'),
(3, 'Çamaşır Makinesi', 5000, 'XY'),
(4, 'Televizyon', 10000, 'AD'),
(5, 'Masa', 2000, 'YD'),
(6, 'KAHVALTI SETİ', 1000, 'YZ'),
(7, 'Fincan Takımı', 1500, 'UK'),
(8, '20\'li Demleme Çay', 80, 'TR'),
(9, 'Dondurulmuş Pizza', 120, 'DR'),
(10, 'Hazır Börek', 200, 'YK'),
(11, 'Oyun Konsolu', 4000, 'TX'),
(12, 'Çanta', 300, 'RT'),
(13, 'Mikrofon', 700, 'ZP'),
(14, 'Gözlük', 800, 'PN');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `manageritem`
--

CREATE TABLE `manageritem` (
  `id` int(11) NOT NULL,
  `item` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `customername` varchar(50) NOT NULL,
  `customersurname` varchar(50) NOT NULL,
  `customeraddress` varchar(50) NOT NULL,
  `cargobranch` varchar(50) NOT NULL,
  `deliverydate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `manageritem`
--

INSERT INTO `manageritem` (`id`, `item`, `price`, `customername`, `customersurname`, `customeraddress`, `cargobranch`, `deliverydate`) VALUES
(1, 'Çamaşır Makinesi', 250, 'Cengiz', 'Yavuz', 'İstanbul-Ataşehir', 'ASDS', '2024-05-06 20:12:27'),
(2, 'Bilgisayar', 15000, 'Bekir', 'Yavuz', 'İstanbul-Ataşehir', 'XSSS', '2024-05-05 10:58:37');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `customerlogin`
--
ALTER TABLE `customerlogin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`),
  ADD KEY `id_2` (`id`);

--
-- Tablo için indeksler `customerorder`
--
ALTER TABLE `customerorder`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `customerpurchase`
--
ALTER TABLE `customerpurchase`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `customerregistration`
--
ALTER TABLE `customerregistration`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `manageritem`
--
ALTER TABLE `manageritem`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Tablo için AUTO_INCREMENT değeri `customerlogin`
--
ALTER TABLE `customerlogin`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Tablo için AUTO_INCREMENT değeri `customerorder`
--
ALTER TABLE `customerorder`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `customerpurchase`
--
ALTER TABLE `customerpurchase`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `customerregistration`
--
ALTER TABLE `customerregistration`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Tablo için AUTO_INCREMENT değeri `items`
--
ALTER TABLE `items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Tablo için AUTO_INCREMENT değeri `manageritem`
--
ALTER TABLE `manageritem`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
