SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;


CREATE TABLE buycartable (
  fangId varchar(20) NOT NULL,
  gukeId varchar(50) NOT NULL,
  KEY fangId (fangId),
  KEY gukeId (gukeId)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

INSERT INTO buycartable (fangId, gukeId) VALUES
('009', 'siran');

CREATE TABLE dindantable (
  Soleld varchar(50) NOT NULL,
  Userid varchar(50) NOT NULL,
  rid varchar(50) NOT NULL,
  Soledate datetime NOT NULL,
  Number int(11) NOT NULL,
  State varchar(2) NOT NULL,
  Price decimal(8,2) NOT NULL,
  PRIMARY KEY (Soleld),
  KEY Userid (Userid)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

CREATE TABLE fangtable (
  rid varchar(20) NOT NULL,
  Rprice decimal(8,2) NOT NULL,
  raddress varchar(50) NOT NULL,
  rtype varchar(20) NOT NULL,
  rstate varchar(2) NOT NULL,
  PRIMARY KEY (rid)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

INSERT INTO fangtable (rid, Rprice, raddress, rtype, rstate) VALUES
('001', '250.00', '4楼408房', '普通客房', '空'),
('002', '250.00', '4楼409房', '普通客房', '空'),
('003', '250.00', '4楼410房', '普通客房', '空'),
('004', '250.00', '4楼411房', '普通客房', '满'),
('005', '300.00', '4楼412房', '普通客房', '空'),
('006', '250.00', '4楼413房', '普通客房', '空'),
('007', '800.00', '8楼804房', '商务客房', '满'),
('008', '800.00', '8楼805房', '商务客房', '空'),
('009', '800.00', '8楼806房', '商务客房', '空'),
('010', '800.00', '8楼808房', '商务客房', '空'),
('020', '800.00', '8楼809房', '商务客房', '空'),
('030', '800.00', '8楼810房', '商务客房', '空'),
('040', '800.00', '8楼811房', '商务客房', '空'),
('050', '800.00', '8楼812房', '商务客房', '空'),
('060', '800.00', '8楼807房', '商务客房', '空');

CREATE TABLE usertable (
  UserId varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (UserId)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

INSERT INTO usertable (UserId, `Password`, `type`) VALUES
('siran', 'linsiran', 'us'),
('shanshan', 'zenshanshan', 'us'),
('kunjin', 'liaokunjin', 'us'),
('xiaoxiang', 'hbj514200', 'ad');

CREATE TABLE danfangtable (
  Soleld varchar(50) NOT NULL,
  rid varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;