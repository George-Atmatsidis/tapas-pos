# tapas-tpv

Note: This project was originally started by [Francisco Morero Peyrona](https://gitgub.com/peyrona).

--------------------------------------
   SOBRE ESTE PROYECTO
--------------------------------------

La finalidad de este proyecto es exclusivamente didáctica: una amiga pensó
montar una taberna y me puse a pensar cómo sería un TPV muy sencillo de
utilizar, amigable y con la mínima curva de aprendizaje posible.
Cuando lo tenía "dibujado" pensé que sería una buena aplicación para aquellas
personas que se inician en Swing y Bases de Datos y decidí terminarlo para que
sirva como introducción y referencia en este campo de aplicaciones Java.

Algunas características son:

* Tiene un montón de buenas prácticas de referencia (y algunas malas también).

* Puesto que el objetivo es explicar cómo se puede integrar Swing y JDBC, no he
  utilizado JPA: como digo, he intentado que sea lo más sencillo posible.

* Las cosas se hacen de un modo muy artesanal: muchas de ellas se podrían hacer
  con menos trabajo, pero la intención de hacerlas de este modo es que "se vean
  las tripas", para que se entienda "qué pasa por debajo".

* Está terminado al 90% (queda la parte de impresión y listados), pero aún así
  es muy operativo. Con muy poco trabajo adicional se podría dejar listo para
  producción. Si a alguien le interesa terminarlo, que busque por todo el código
  la cadena "// TODO", ahí están los comentarios que explican qué falta.
  También hay algún "// NEXT" que he dejado para avanzarlo yo en un futuro.

* Hay algunas mejoras claras (como poner un sistema de desplazamiento más
  elegante a los paneles de botones. Pero no forma parte de la finalidad de este
  proyecto.

* Aunque el JavaDoc no está muy completo (no comento aquellos métodos que son
  obvios), el código en sí está bastante comentado: doy muchas explicaciones de
  qué estoy haciendo y por qué lo hago de ese modo.

* Todos los comentarios y la documentación están en Castellano, sin embargo los
  nombres de clases, métodos y variables están en inglés: me parece más claro de
  este modo.

* Intencionadamente he hecho las mismas cosas de diferentes modos para mostrar
  distintas opciones.

* Aunque se puede utilizar cualquier IDE para estudiarlo, al estar fabricado con
  NetBeans, resultará más fácil si se usa éste (especialmente por Mattise).

* Para los impacientes: la primera vez que se ejecuta tarda más porque tiene que
  crear la DB.

* La aplicación la he construido intentando que consuma la mínima memoria y CPU
  posibles (pero sin llegar a obsesionarme, por lo que aún se puede hacer alguna
  mejora en éste área). La aplicación puede ejecutarse en PCs antiguos: con
  pocos recursos de hardware.

* Los iconos son "open", es decir, legales (tomados de Wiki Commons)

* Aquél que encuentre un bug (sé que los hay), por favor que lo reporte
  utilizando la herramienta de la pág web del programa
  (http://code.google.com/p/tapas-tpv/issues/).
  Y si de paso me da la solución, se lo agradeceré aún más.

* El programa (como todos) es muy mejorable, pero hasta aquí he llegado (aunque
  espero poder diponer de algún rato perdido para ir mejorándolo).

* La licencia es GPL v.3, lo que significa que si mejoras algo, tu código
  también será GPL v.3 y tienes la obligación de hacerlo público.

* Este proyecto ha estado "cogiendo polvo" en el HD casi 3 años, por lo que
  algunas cosas están obsoletas: pido disculpas.

--------------------------------------
   PARA OPERAR CON LA APLICACIÓN
--------------------------------------
Si quieres "jugar" con la aplicación, antes de nada debes visitar la parte
de configuración, a la que se accede desde el botón "Oficina" de la toolbar.

Al menos debes crea una categoría de productos (p.ej. Cervezas) y uno o
varios productos para esa categoría (p.ej. Mahou, Cruzcampo, Coronita, ...)
