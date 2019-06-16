-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 16, 2019 at 03:51 PM
-- Server version: 10.1.22-MariaDB
-- PHP Version: 7.0.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_java`
--

-- --------------------------------------------------------

--
-- Stand-in structure for view `query_faktur_transaksi`
-- (See below for the actual view)
--
CREATE TABLE `query_faktur_transaksi` (
`kd_transaksi` varchar(20)
,`kd_barang` varchar(50)
,`nama_barang` varchar(50)
,`harga` varchar(50)
,`jumlah` varchar(50)
,`subtotal` varchar(50)
,`kd_laporan` varchar(15)
,`total` int(20)
,`bayar` int(20)
,`kembalian` int(20)
,`tanggal` date
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `query_faktutransaksi`
-- (See below for the actual view)
--
CREATE TABLE `query_faktutransaksi` (
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `query_pemasokan`
-- (See below for the actual view)
--
CREATE TABLE `query_pemasokan` (
`kd_pasok` varchar(30)
,`kd_barang` varchar(30)
,`nama_barang` varchar(30)
,`jumlah` int(30)
,`tgl_masuk` varchar(100)
,`pemasok` varchar(30)
,`stok` int(50)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `query_total`
-- (See below for the actual view)
--
CREATE TABLE `query_total` (
`subtotal` varchar(50)
);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_barang`
--

CREATE TABLE `tbl_barang` (
  `kd_barang` varchar(20) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `jenis_barang` varchar(30) NOT NULL,
  `harga_beli` int(50) NOT NULL,
  `harga_jual` int(50) NOT NULL,
  `stok` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_barang`
--

INSERT INTO `tbl_barang` (`kd_barang`, `nama_barang`, `jenis_barang`, `harga_beli`, `harga_jual`, `stok`) VALUES
('KD001', 'Mie', 'Item 1', 12000, 15000, 455),
('KD002', 'Teh', 'Minum', 1000, 2000, 246),
('KD003', 'Kue', 'Item 1', 2000, 3000, 42),
('KD004', 'Cakue', 'Makanan', 2000, 3000, 24),
('KD005', 'Jamu', 'Minuman', 2000, 3000, 120);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_laporan`
--

CREATE TABLE `tbl_laporan` (
  `kd_laporan` varchar(15) NOT NULL,
  `total` int(20) NOT NULL,
  `bayar` int(20) NOT NULL,
  `kembalian` int(20) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_laporan`
--

INSERT INTO `tbl_laporan` (`kd_laporan`, `total`, `bayar`, `kembalian`, `tanggal`) VALUES
('TR00001', 39000, 40000, 1000, '2019-06-08'),
('TR00002', 54000, 60000, 6000, '2019-06-08'),
('TR00003', 342000, 350000, 8000, '2019-06-16');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_login`
--

CREATE TABLE `tbl_login` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_login`
--

INSERT INTO `tbl_login` (`username`, `password`) VALUES
('tebew', 'tebew');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_pasok`
--

CREATE TABLE `tbl_pasok` (
  `kd_pasok` varchar(30) NOT NULL,
  `kd_barang` varchar(30) NOT NULL,
  `nama_barang` varchar(30) NOT NULL,
  `jumlah` int(30) NOT NULL,
  `tgl_masuk` varchar(100) NOT NULL,
  `pemasok` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_pasok`
--

INSERT INTO `tbl_pasok` (`kd_pasok`, `kd_barang`, `nama_barang`, `jumlah`, `tgl_masuk`, `pemasok`) VALUES
('P00001', 'KD001', 'Mie', 100, '15-16-2019', 'Tuan Ku'),
('P00002', 'KD002', 'Teh', 30, '15-06-2019', 'Jajang'),
('P00003', 'KD003', 'Teh', 30, '15-06-2019', 'Iteung'),
('P00004', 'KD001', 'Mie', 10, '16-09-2019', 'tung');

--
-- Triggers `tbl_pasok`
--
DELIMITER $$
CREATE TRIGGER `pasok_barang` AFTER INSERT ON `tbl_pasok` FOR EACH ROW BEGIN
UPDATE tbl_barang
set stok = stok + NEW.jumlah
WHERE
kd_barang = NEW.kd_barang;
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_pemasok`
--

CREATE TABLE `tbl_pemasok` (
  `kd_pemasok` varchar(50) NOT NULL,
  `nama_pemasok` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `nohp` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_pemasok`
--

INSERT INTO `tbl_pemasok` (`kd_pemasok`, `nama_pemasok`, `alamat`, `nohp`) VALUES
('p001', 'gatau', 'tetew', 9009),
('p002', 'uhuy', 'tetw', 9898),
('p003', 'tatang', 'rumahnya lah', 8547575),
('P004', 'yuyuh', 'hehek', 20202);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_pengguna`
--

CREATE TABLE `tbl_pengguna` (
  `kd_pengguna` varchar(30) NOT NULL,
  `nama_pengguna` varchar(30) NOT NULL,
  `jk` varchar(10) NOT NULL,
  `nohp` int(15) NOT NULL,
  `jabatan` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_pengguna`
--

INSERT INTO `tbl_pengguna` (`kd_pengguna`, `nama_pengguna`, `jk`, `nohp`, `jabatan`, `username`, `password`) VALUES
('KD001', 'admin', 'Laki-Laki', 8575757, 'Kasir', 'admin', 'admin'),
('KD0012', 'tatag', 'Laki-Laki', 8080, 'Kasir', 'teka', 'teka'),
('KD002', 'Kasir', 'Laki-Laki', 85767621, 'Kasir', 'kasir', 'kasir'),
('kd09', 'lsfj', 'Laki-Laki', 5454, 'Kasir', 'sdf', 'sdf'),
('kd0900', 'tebew', 'Laki-Laki', 98, 'Manager', 'alskfj', 'lakdsjf'),
('lksj098', 'laskdjf', 'Laki-Laki', 5454, 'Kasir', 'asf', 'sdf');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_transaksi`
--

CREATE TABLE `tbl_transaksi` (
  `kd_transaksi` varchar(20) NOT NULL,
  `kd_barang` varchar(50) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `harga` varchar(50) NOT NULL,
  `jumlah` varchar(50) NOT NULL,
  `subtotal` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Triggers `tbl_transaksi`
--
DELIMITER $$
CREATE TRIGGER `transaksi` AFTER INSERT ON `tbl_transaksi` FOR EACH ROW BEGIN
UPDATE tbl_barang
set stok = stok - NEW.jumlah
WHERE
kd_barang = NEW.kd_barang;
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `temp`
--

CREATE TABLE `temp` (
  `kd_transaksi` varchar(20) NOT NULL,
  `kd_barang` varchar(50) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `harga` varchar(50) NOT NULL,
  `jumlah` varchar(50) NOT NULL,
  `subtotal` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure for view `query_faktur_transaksi`
--
DROP TABLE IF EXISTS `query_faktur_transaksi`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `query_faktur_transaksi`  AS  select `temp`.`kd_transaksi` AS `kd_transaksi`,`temp`.`kd_barang` AS `kd_barang`,`temp`.`nama_barang` AS `nama_barang`,`temp`.`harga` AS `harga`,`temp`.`jumlah` AS `jumlah`,`temp`.`subtotal` AS `subtotal`,`tbl_laporan`.`kd_laporan` AS `kd_laporan`,`tbl_laporan`.`total` AS `total`,`tbl_laporan`.`bayar` AS `bayar`,`tbl_laporan`.`kembalian` AS `kembalian`,`tbl_laporan`.`tanggal` AS `tanggal` from (`temp` join `tbl_laporan` on((`temp`.`kd_transaksi` = `tbl_laporan`.`kd_laporan`))) ;

-- --------------------------------------------------------

--
-- Structure for view `query_faktutransaksi`
--
DROP TABLE IF EXISTS `query_faktutransaksi`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `query_faktutransaksi`  AS  select `temp`.`No` AS `No`,`temp`.`kd_transaksi` AS `kd_transaksi`,`temp`.`kd_barang` AS `kd_barang`,`temp`.`nama_barang` AS `nama_barang`,`temp`.`harga` AS `harga`,`temp`.`jumlah` AS `jumlah`,`temp`.`subtotal` AS `subtotal`,`tbl_laporan`.`kd_laporan` AS `kd_laporan`,`tbl_laporan`.`total` AS `total`,`tbl_laporan`.`bayar` AS `bayar`,`tbl_laporan`.`kembalian` AS `kembalian`,`tbl_laporan`.`tanggal` AS `tanggal` from (`temp` join `tbl_laporan` on((`temp`.`kd_transaksi` = `tbl_laporan`.`kd_laporan`))) ;

-- --------------------------------------------------------

--
-- Structure for view `query_pemasokan`
--
DROP TABLE IF EXISTS `query_pemasokan`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `query_pemasokan`  AS  select `tbl_pasok`.`kd_pasok` AS `kd_pasok`,`tbl_pasok`.`kd_barang` AS `kd_barang`,`tbl_pasok`.`nama_barang` AS `nama_barang`,`tbl_pasok`.`jumlah` AS `jumlah`,`tbl_pasok`.`tgl_masuk` AS `tgl_masuk`,`tbl_pasok`.`pemasok` AS `pemasok`,`tbl_barang`.`stok` AS `stok` from (`tbl_pasok` join `tbl_barang` on((`tbl_pasok`.`kd_barang` = `tbl_barang`.`kd_barang`))) ;

-- --------------------------------------------------------

--
-- Structure for view `query_total`
--
DROP TABLE IF EXISTS `query_total`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `query_total`  AS  select `temp`.`subtotal` AS `subtotal` from `temp` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_barang`
--
ALTER TABLE `tbl_barang`
  ADD PRIMARY KEY (`kd_barang`);

--
-- Indexes for table `tbl_laporan`
--
ALTER TABLE `tbl_laporan`
  ADD PRIMARY KEY (`kd_laporan`);

--
-- Indexes for table `tbl_pasok`
--
ALTER TABLE `tbl_pasok`
  ADD PRIMARY KEY (`kd_pasok`);

--
-- Indexes for table `tbl_pemasok`
--
ALTER TABLE `tbl_pemasok`
  ADD PRIMARY KEY (`kd_pemasok`);

--
-- Indexes for table `tbl_pengguna`
--
ALTER TABLE `tbl_pengguna`
  ADD PRIMARY KEY (`kd_pengguna`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
