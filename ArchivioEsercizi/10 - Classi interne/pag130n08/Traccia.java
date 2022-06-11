class Traccia {/*
  Realizzare la classe Pizza, in modo che ad ogni oggetto si possano assegnare
  degli ingredienti, scelti da un elenco fissato. Ad ogni ingrediente è
  associato il numero di calorie che apporta alla pizza. Gli oggetti di tipo
  Pizza sono dotati di ordinamento naturale, sulla base del numero totale di
  calorie. Infine, gli oggetti di tipo Pizza sono anche clonabili.            */

  public static void main(String[] argv) {
    // Esempio d’uso:
    Pizza margherita = new Pizza(),
          marinara = new Pizza();
    margherita.addIngrediente(Pizza.Ingrediente.POMODORO);
    margherita.addIngrediente(Pizza.Ingrediente.MOZZARELLA);
    marinara.addIngrediente(Pizza.Ingrediente.POMODORO);
    marinara.addIngrediente(Pizza.Ingrediente.AGLIO);
    Pizza altra = margherita.clone();
    System.out.println(altra.compareTo(marinara));
  }
  // Output: 1
}
