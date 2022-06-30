// Dato il seguente frammento di codice Java:
class Account {
  public Person owner() { ... }
  public Integer balance() { ... }
  public void changeOwner(Person newOwner) { ... }
  public static Account create(Person owner) { ... }
}
Account a = ...
/*
  Assegnare il tipo appropriato ai seguenti method references, usando una delle
  interfacce Function, Supplier e Consumer:
      a) Account::create
      b) Account::owner
      c) a::owner
      d) a::changeOwner
      e) a::balance
      f) Account::balance

SOLUZIONI:

  a) Function<Person, Account> f = Account::create;

  b) Function<Account, Person> f = Account::owner;

  c) Supplier<Person> s = a::owner;

  d) Consumer<Person> c = a::changeOwner;

  e) Supplier<Integer> s = a::balance;

  f) Function<Account, Integer> f = Account::balance;
*/
