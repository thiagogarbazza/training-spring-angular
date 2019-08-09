package com.github.thiagogarbazza.training.springangular.report.commom.excel;

import lombok.Getter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.report.commom.excel.ExcelUtils.criarEstiloLegendaTabela;
import static com.github.thiagogarbazza.training.springangular.report.commom.excel.ExcelUtils.criarEstiloTabelaCabecalho01;
import static com.github.thiagogarbazza.training.springangular.report.commom.excel.ExcelUtils.criarEstiloTabelaCelulaNao;
import static com.github.thiagogarbazza.training.springangular.report.commom.excel.ExcelUtils.criarEstiloTabelaCelulaSim;
import static lombok.AccessLevel.PROTECTED;

public abstract class AbstractRelatorioTabelaSimplesExcel<T> extends AbstractRelatorioExcel {

  private final CellStyle estiloDeLinhaNao;

  private final CellStyle estiloDeLinhaSim;

  private final CellStyle estiloDoCabecalho;

  @Getter(PROTECTED)
  private final CellStyle estiloLegendaDaTabela;

  protected AbstractRelatorioTabelaSimplesExcel(String nome) {
    super(nome);
    estiloDeLinhaNao = criarEstiloTabelaCelulaNao(getWorkbook());
    estiloDeLinhaSim = criarEstiloTabelaCelulaSim(getWorkbook());
    estiloDoCabecalho = criarEstiloTabelaCabecalho01(getWorkbook());
    estiloLegendaDaTabela = criarEstiloLegendaTabela(getWorkbook());
  }

  protected abstract Collection<Coluna<T>> colunas();

  protected abstract Collection<T> itens();

  @Override
  protected void construir() {
    Sheet sheet = criarSheete();
    criarCabecalho();
    criarCabecalhoTabela(sheet);
    criarLinhasTabela();
    criarLegendaTabela();
  }

  protected void construir(String nomeSheet) {
    Sheet sheet = criarSheete(nomeSheet);
    criarCabecalho();
    criarCabecalhoTabela(sheet);
    criarLinhasTabela();
    criarLegendaTabela();
  }

  protected void criarCabecalho() {
    // Quando alguma implementação quiser adicionar alguma cabeçalho.
  }

  protected Cell criarCelulaCabecalhoEmLinha(Row row, int coluna, String value) {
    Cell cell = row.createCell(coluna);
    cell.setCellValue(value);
    cell.setCellStyle(estiloDoCabecalho);

    return cell;
  }

  protected void criarLegendaTabela() {
    // Quando alguma implementação quiser adicionar alguma legenda após a tabela.
  }

  private void criarCabecalhoTabela(final Sheet sheet) {
    final Row linha = criarLinha();

    colunas().forEach(coluna -> {
      Cell celula = linha.createCell(coluna.getIndex());
      celula.setCellValue(coluna.getTitulo());
      celula.setCellStyle(estiloDoCabecalho);

      sheet.setColumnWidth(coluna.getIndex(), coluna.getTamanho());
    });
  }

  private void criarLinhasTabela() {
    itens().forEach(item -> {
      final Row linha = criarLinha();
      final CellStyle estiloDaLinha = linha.getRowNum() % 2 == 0 ? estiloDeLinhaSim : estiloDeLinhaNao;
      colunas().forEach(coluna -> preencherCelula(linha, coluna.getIndex(), coluna.getValor(item), estiloDaLinha));
    });
  }
}

