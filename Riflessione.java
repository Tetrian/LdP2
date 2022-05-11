
/*~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~*/

 /* Esercizio 1
	Implementare un metodo, chiamato reset, che prende come argomento un
	oggetto ed imposta a zero tutti i suoi campi interi pubblici
  */
   public static void reset(Object obj) throws IllegalAccessException {
	   Field[] campi = obj.getClass().getFields();
	   for(int i = 0; i < campi.length; ++i)
		   if (campi[i].getType() == int.class)
			   campi[i].set(obj, 0);
	}

/*~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~*/

 /* Esercizio 2
	Implementare un metodo che, dato un oggetto, parte dalla classe che
	rappresenta il tipo effettivo dell'oggetto e ne restituisce la superclasse
	più generale, escludendo Object (quindi, la penultima classe, prima di
	arrivare a Object)
  */
	public static Class<?> getAncestorClass(Object obj) {
    if (obj.getClass().getSuperclass() == null)
      throw new IllegarlArgumentException("The object cannot be a Object type");
		Class<?> current = obj.getClass();
		while (current.getSuperclass() != Object.class) {
			current = current.getSuperclass();
		}
		return current;
	}

/*~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~*/
