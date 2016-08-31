  <?php 
      include 'header.php';


  ?>
<section class="main">
<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Cadastrar Artigo</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Nome_Completo">Nome Completo</label>  
  <div class="col-md-8">
  <input id="Nome_Completo" name="Nome_Completo" placeholder="ex: José da Silva" class="form-control input-md" required="" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="inst">Instituição</label>  
  <div class="col-md-8">
  <input id="inst" name="inst" placeholder="ex: UFPB" class="form-control input-md" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Projeto">Nome do Projeto</label>  
  <div class="col-md-8">
  <input id="Projeto" name="Projeto" placeholder="" class="form-control input-md" type="text">
    
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="area">Área de Afinidade</label>
  <div class="col-md-8">
    <select id="area" name="area" class="form-control">
      <option value="10301003">TEORIA DA COMPUTAÇÃO</option>
      <option value="10301011">COMPUTABILIDADE E MODELOS DE COMPUTAÇÃO</option>
      <option value="10301020">LINGUAGEM FORMAIS E AUTÔMATOS</option>
      <option value="10301038">ANÁLISE DE ALGORÍTMOS E COMPLEXIDADE DE COMPUTAÇÃO</option>
      <option value="10301046">LÓGICAS E SEMÂNTICA DE PROGRAMAS</option>
      <option value="10302000">MATEMÁTICA DA COMPUTAÇÃO</option>
      <option value="10302018">MATEMÁTICA SIMBÓLICA</option>
      <option value="10302026">MODELOS ANALÍTICOS E DE SIMULAÇÃO</option>
      <option value="10303006">METODOLOGIA E TÉCNICAS DA COMPUTAÇÃO</option>
      <option value="10303014">LINGUAGENS DE PROGRAMAÇÃO</option>
      <option value="10303022">ENGENHARIA DE SOFTWARE</option>
      <option value="10303030">BANCO DE DADOS</option>
      <option value="10303049">SISTEMAS DE INFORMAÇÃO</option>
      <option value="10303057">PROCESSAMENTO GRÁFICO (GRAPHICS)</option>
      <option value="10304002">SISTEMA DE COMPUTAÇÃO</option>
      <option value="10304010">HARDWARE</option>
      <option value="10304029">ARQUITETURA DE SISTEMAS DE COMPUTAÇÃO</option>
      <option value="10304037">SOFTWARE BÁSICO</option>
      <option value="10304045">TELEINFORMÁTICA</option>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="keywords">Palavras-chave</label>  
  <div class="col-md-8">
  <input id="keywords" name="keywords" placeholder="" class="form-control input-md" type="text">
  <span class="help-block">Separe-as por vírgula(,), ponto final(.) ou ponto e vírgula(;)</span>  
  </div>
</div>

<!-- Button (Double) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="button1id"></label>
  <div class="col-md-8">
    <button id="button1id" name="button1id" class="btn btn-warning">Retornar</button>
    <button id="button2id" name="button2id" class="btn btn-success">Próximo</button>
  </div>
</div>

</fieldset>

</form>




</section>






    <?php 
      include 'footer.php';


  ?>