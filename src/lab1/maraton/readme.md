# Маратон

Да се дефинира интерфејс `IMaraton` со методи:

- `Atleticar najdobroVreme()` - го враќа победникот на маратонот
- `int atleticariOd(String s)` - го враќа бројот на атлетичари со земја на потекло `s`.

Да се дефинира класа `Atleticar`. За секој атлетичар се чуваат податоци за име `String`, пол `String`, возраст `int` и
време на истрчување изразено во секунди double и земја на потекло `String`. За оваа класа треба да се на располагање
следните методи:

- конструктори (default и со параметри)
- `set` и `get` методи
- `toString()` - формат: име / возраст / земја на потекло / време на истрчување
  (сите параметри одделени со празно место)

Да се дефинира класа `Maraton` што го имплементира интерфејсот `IMaraton`. За секој маратонот се чуваат податоци за
местото на одржување `String`, година `int`, низа од атлетичари `Atleticar[]`. За оваа класа да се имплементираат:

- конструктори (default и со параметри)
- `set` и `get` методи
- `toString()` - место на одржување / година / атлетичарите учесници на маратонот
  (сите параметри одделени со нов ред)
- `najdobroVreme()`
- `atleticariOd(String s)`