����   = �
      java/lang/Object <init> ()V	  	 
   java/lang/System out Ljava/io/PrintStream;  How many runways?
      java/io/PrintStream println (Ljava/lang/String;)V  java/util/Scanner	     in Ljava/io/InputStream;
     (Ljava/io/InputStream;)V
     ! nextInt ()I # Question_8/Departure
 " %  & (I)V ( How many planes? * java/util/Random
 ) 
 ) -   . (I)I 0 Question_8/Plane   2 3 4 makeConcatWithConstants (I)Ljava/lang/String;
 / 6  7 (Ljava/lang/String;I)V
 " 9 : ; assignPlaneToRunway (LQuestion_8/Plane;)V
 " = > ? 
getRunways ()Ljava/util/List; A B C D ! java/util/List size A F G H get (I)Ljava/lang/Object; J Question_8/Runway
 I L M ? 	getPlanes
 O P Q R S java/lang/String valueOf &(Ljava/lang/Object;)Ljava/lang/String;  U 3 V '(ILjava/lang/String;)Ljava/lang/String; X Question_8/AirportSimulation Code LineNumberTable LocalVariableTable this LQuestion_8/AirportSimulation; main ([Ljava/lang/String;)V departureDirection I plane LQuestion_8/Plane; i args [Ljava/lang/String; scnr Ljava/util/Scanner; x departureSystem LQuestion_8/Departure; y random Ljava/util/Random; 
allRunways Ljava/util/List; LocalVariableTypeTable %Ljava/util/List<LQuestion_8/Runway;>; StackMapTable f MethodParameters 
SourceFile AirportSimulation.java BootstrapMethods z
 { | } 3 ~ $java/lang/invoke/StringConcatFactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; � Plane � Runway :  InnerClasses � %java/lang/invoke/MethodHandles$Lookup � java/lang/invoke/MethodHandles Lookup ! W           Y   /     *� �    Z        [        \ ]   	 ^ _  Y  �  	   �� � � Y� � L+� =� "Y� $N� '� +� 6� )Y� +:6� )� ,6� /Y� 1  � 5:-� 8����-� <:6� @ � (� � E � I� K� N� T  � ���ұ    Z   F           !  )  /  8 ! B " J # \ & b ! h * n + } , � + � . [   p  J  ` a  \  b c  ; - d a  q 1 d a    � e f    � g h   � i a  ! � j k  / t l a  8 k m n  n 5 o p  q     n 5 o r  s   % � ;  t  " )  � ,�  A� 0 u    e    v    w x     y   y  � �   
  � � � 