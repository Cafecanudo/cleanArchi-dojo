# Clean Arch. Dojo

### Objetivos gerais
Este dojo tem como objetivo desenvolver entendimento de um design solido de um projeto baseado no estudo do livro [Clean Architecture](https://www.amazon.com.br/Clean-Architecture-Craftsmans-Software-Structure-ebook/dp/B075LRM681/ref=asc_df_B075LRM681/?tag=googleshopp00-20&linkCode=df0&hvadid=379725685153&hvpos=&hvnetw=g&hvrand=14218642289539629535&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=20088&hvtargid=pla-406131052745&psc=1) e [SOLID](https://www.amazon.com.br/Clean-Code-Handbook-Software-Craftsmanship-ebook/dp/B001GSTOAM/ref=pd_sim_351_1/140-5095746-4976859?_encoding=UTF8&pd_rd_i=B001GSTOAM&pd_rd_r=4c433c94-00fb-404e-8493-a36ad5fea146&pd_rd_w=l5fQN&pd_rd_wg=t4uJk&pf_rd_p=1dd738b7-cb33-4745-82d8-d54bbfb14c91&pf_rd_r=0XVFWVD64PQE87NSKTGQ&psc=1&refRID=0XVFWVD64PQE87NSKTGQ).
### Modelo de dados
![](modelo-dados.PNG)
### Estudo de caso
Sua equipe trabalha em uma parte muito maior de um projeto financeiro com focos em produtos e viagens, seu squad recebeu como tarefa implementar um meio de pagamento online usando cartão de credito ou débito, seu time deve-se garantir todo o workflow da transação. Assumindo que exista um produto e está em uma loja seja em São Paulo, seu time deve atender os seguintes requisitos:
#### Casos
> - Permitir que selecionar produtos e sua quantidade
> - Permitir informar um estado para tributação
> - Permitir informar o numero de cartão
> 	- Meio de pagamento(Credito ou Debito)
> 	- Quantidade de Parcelas
> - Transmitir dados da compra para API externa efetuar cobrança
> - Exibir mensagens de cobranças de erro ou sucesso

#### Requisitos funcionais
> - Quando for informado os estados DF e GO deve-se cobrar R$ 40,00 de frete, quando informar PA deve-se cobrar R$ 55,00 de frete, quando for enviado para SP não deve se cobrar frete e para os demais cobrar R$ 20,00 frete.
> - Quando for informado o estado de RJ, MG, DF devem ser cobrados 2.89% de tributos sobre o valor total da compra e 3.75% para os demais.
>  - Quando for informado compra a credito e enviar para estados MG, DF e GO, deve-se dividir ICMS do produto em 2 e somar ao valor total da compra, para os demais deve-se somar o ICMS ao valor da compra.
> - Não deve permitir concluir compra se cartão não possuir saldo.
> - Salvar em banco de dados um log os dados da transação em string simples.

#### Requisitos não funcionais
> - Usar TDD
> - SOLID
> - Clean Architecture
> - Escrever um código em que toda a equipe concorde, independente da qualidade.
> - Código não pode ter dependências com bibliotecas externas, excepcionalmente Lombok*.
> - Obrigatoriamente se divirtam ou parem.

#### Referencias de estrutura de Clean Architecture

![](https://marsner.com/wp-content/uploads/test-driven-development-TDD.png)

![](https://images.ctfassets.net/1es3ne0caaid/2zvDDUcdpuYqIM06WgU2sC/d706d509886f88be185fa007f6b43402/clean-architecture-ex-4.png)

![](https://cdn-ak.f.st-hatena.com/images/fotolife/o/open8tech/20190310/20190310035102.png)

![](https://helpdev.com.br/wp-content/uploads/2020/05/Screenshot-from-2020-05-20-23-29-10.png)
