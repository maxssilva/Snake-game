
public class Coments {
    /*
   001**
    pacote void público ()
Faz com que esta janela seja dimensionada para se ajustar ao tamanho e layouts 
    preferidos de seus subcomponentes. A largura e altura resultantes da janela
    são aumentadas automaticamente se qualquer uma das dimensões for menor que 
    o tamanho mínimo, conforme especificado pela chamada anterior do 
    método setMinimumSize.
Se a janela e / ou seu proprietário ainda não puderem ser exibidos, ambos serão
   
    
    002**
    public void setDefaultCloseOperation (operação int)
Define a operação que acontecerá por padrão quando o usuário iniciar um 
    "fechamento" neste quadro. Você deve especificar uma das seguintes opções:

DO_NOTHING_ON_CLOSE (definido em WindowConstants): Não faça nada; requer que o 
    programa controle a operação no windowClosing método de
    um WindowListenerobjeto registrado .
HIDE_ON_CLOSE (definido em WindowConstants): Oculta automaticamente o quadro 
    após invocar quaisquer WindowListener objetos registrados .
DISPOSE_ON_CLOSE (definido em WindowConstants): Oculta e descarta 
    automaticamente o quadro após invocar quaisquer WindowListener objetos
    registrados .
EXIT_ON_CLOSE (definido em JFrame): Saia do aplicativo usando o System 
    exitmétodo. Use isso apenas em aplicativos.
O valor é definido como HIDE_ON_CLOSEpadrão. Alterações no valor desta 
    propriedade causam o disparo de um evento de alteração de propriedade,
    com o nome de propriedade "defaultCloseOperation".

Nota : Quando a última janela exibível na máquina virtual Java (VM) é 
    descartada, a VM pode ser encerrada. Consulte AWT Threading Issues para
        obter mais informações.

Parâmetros:
operation - a operação que deve ser realizada quando o usuário fecha o quadro
    
    
    003**
    
    setVisible
public void setVisible (boolean b)
Mostra ou oculta isso Windowdependendo do valor do parâmetro b.
Se o método mostra a janela, então a janela também é focada nas seguintes 
    condições:

O Windowatende aos requisitos descritos no isFocusableWindow()método.
O Window's autoRequestFocuspropriedade é do truevalor.
O sistema de janelas nativo permite que o Windowfoco seja.
Há uma exceção para a segunda condição (o valor do autoRequestFocusimóvel). 
    A propriedade não é levada em consideração se a janela for um diálogo modal,
    que bloqueia a janela atualmente em foco.
Os desenvolvedores nunca devem presumir que a janela é a janela em foco ou ativa
    até que receba um evento WINDOW_GAINED_FOCUS ou WINDOW_ACTIVATED.

Substitui:
setVisible em aula Component
Parâmetros:
b- se true, torna o Windowvisível, caso contrário, oculta o Window. Se o Windowe
    / ou seu proprietário ainda não puderem ser exibidos, ambos serão exibidos. 
    O Windowserá validado antes de se tornar visível. Se o Windowjá estiver 
    visível, isso o trará Windowpara a frente.
If false, oculta isso Window, seus subcomponentes e todos os seus filhos. O 
    Windowe seus subcomponentes podem ficar visíveis novamente com uma chamada
    para #setVisible(true).
    
    
    004**
    
    public void setLocationRelativeTo ( Componente  c)
Define a localização da janela em relação ao componente especificado de acordo 
    com os seguintes cenários.
A tela de destino mencionada abaixo é uma tela na qual a janela deve ser 
    colocada após o método setLocationRelativeTo ser chamado.

    
Se o componente for null, ou se o GraphicsConfigurationassociado a este 
    componente for null, a janela será posicionada no centro da tela. O ponto 
    central pode ser obtido com o GraphicsEnvironment.getCenterPointmétodo.
Se o componente não estiver null, mas não estiver sendo exibido no momento, a 
    janela é colocada no centro da tela de destino definida pelo
    GraphicsConfigurationassociado a este componente.
Se o componente não é nulle é mostrado na tela, a janela está localizada de 
    forma que o centro da janela coincida com o centro do componente.
Se a configuração das telas não permite que a janela seja movida de uma tela 
    para a outra, então a janela é colocada apenas no local determinado de 
    acordo com as condições acima e GraphicsConfigurationnão é alterado.

Observação : se a borda inferior da janela estiver fora da tela, a janela será 
    colocada ao lado do Component que estiver mais próximo do centro da tela. 
    Portanto, se o componente estiver à direita da tela, a janela será colocada 
    à sua esquerda e vice-versa.

Se, depois de calculada a localização da janela, a borda superior, esquerda ou    
    direita da janela estiver fora da tela, a janela está localizada de forma 
    que a borda superior, esquerda ou direita da janela coincida com o borda 
    correspondente da tela. Se as bordas esquerda e direita da janela estiverem
    fora da tela, a janela será colocada no lado esquerdo da tela. 
    O posicionamento semelhante ocorrerá se as bordas superior e inferior 
    estiverem fora da tela. Nesse caso, a janela é colocada na parte superior 
    da tela.

O método altera os dados relacionados à geometria. Portanto, o sistema de 
    janelas nativo pode ignorar essas solicitações ou pode modificar os dados 
    solicitados, de modo que o Windowobjeto seja colocado e dimensionado de 
    maneira que corresponda exatamente às configurações da área de trabalho.

Parâmetros:
c - o componente em relação ao qual a localização da janela é determinada
Desde a:
1,4
    
    */
}
