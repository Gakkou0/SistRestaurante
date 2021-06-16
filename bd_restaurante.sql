-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 16-Jun-2021 às 01:52
-- Versão do servidor: 10.4.18-MariaDB
-- versão do PHP: 8.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bd_restaurante`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cadastros`
--

CREATE TABLE `cadastros` (
  `id_conta` int(225) NOT NULL,
  `nome` varchar(225) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `CPF` int(11) NOT NULL,
  `RG` int(11) NOT NULL,
  `telefone` int(11) NOT NULL,
  `genero` varchar(15) NOT NULL,
  `senha` varchar(30) NOT NULL,
  `FunGe` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cadastros`
--

INSERT INTO `cadastros` (`id_conta`, `nome`, `endereco`, `email`, `CPF`, `RG`, `telefone`, `genero`, `senha`, `FunGe`) VALUES
(1, 'qweqe', 'qeweqe', 'eqwe2', 1312313, 3123123, 123123123, 'Homem', '123123123', 1),
(2, 'Francisco Hugo', 'Rua a', 'fhugo.625@gmail.com', 324234423, 234424232, 131312313, 'Homem', 'bancodedados', 1),
(3, 'Ygor', 'sdad', 'dasdasd', 345235345, 324242342, 423423556, 'Mulher', '123456', 1),
(5, 'Adilson', 'rua  meu', 'ddddd', 522775, 578757, 74275725, 'Homem', 'true', 1),
(7, 'eeeee', 'eee', 'ee', 222, 222, 22, 'Homem', '2222', 1),
(10, 'bb', 'bb', 'bb', 434, 434, 4342, 'Homem', '423432', 1),
(11, 'adilson', 'qweqwe', 'qewqeq', 234242, 4324234, 4232432, 'Homem', '14213123', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedidos`
--

CREATE TABLE `pedidos` (
  `Id_pedido` int(225) NOT NULL,
  `prato` varchar(100) NOT NULL,
  `mesa` int(2) NOT NULL,
  `hora` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id` int(225) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `qtd` int(4) NOT NULL,
  `preco` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cadastros`
--
ALTER TABLE `cadastros`
  ADD PRIMARY KEY (`id_conta`);

--
-- Índices para tabela `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`Id_pedido`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cadastros`
--
ALTER TABLE `cadastros`
  MODIFY `id_conta` int(225) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de tabela `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `Id_pedido` int(225) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(225) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
