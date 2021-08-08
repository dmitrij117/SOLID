Использование принципов SOLID при написании Java кода на примере консольного приложения "Онлайн - магазин"

  1. Single Responsibility
 
Реализован при разделение классов по функционалу, например Delivery класс занимающий организацией доставки товаров, класс Shop для работы с товарами находящимися в продаже(на складе) и.т.д.

  2. Open-closed principle
  
Реализован в классах ProductComparatorByPrice, ProductComparatorByRate. Классы открыты для дальнейшего расширения...

  3. Liskov substitution principle
  
Классы Book, Perfume, Watch унаследованы от единого класса Product, могуть играть роль за предка, что фактически показывает работу этого принципа

  4. Dependency inversion principle
  
Реализован в классе Shop, который унаследован < P extends Product>, а также ProductInformation унаследованный от Shop

Также в комментариях отмечено, где применена замена magic number.

Don’t Repeat Yourself, можно например увидеть в реализации метода DisplayCart() класса Delivery, вызов которого неоднократно встречается в классе Main.
