FasdUAS 1.101.10   ��   ��    k             l     ��  ��      custom code     � 	 	    c u s t o m   c o d e   
  
 l     ��  ��    E ? display starting notification status (once after window start)     �   ~   d i s p l a y   s t a r t i n g   n o t i f i c a t i o n   s t a t u s   ( o n c e   a f t e r   w i n d o w   s t a r t )      l     ����  I    ��  
�� .sysonotfnull��� ��� TEXT  m        �   4 B a t t e r y   A l r a m   i s   s t a r t i n g .  �� ��
�� 
appr  m       �     B a t t e r y   O v e r s e e r��  ��  ��        l    ����  I   �� ��
�� .sysodelanull��� ��� nmbr  m    	���� ��  ��  ��        l     ��������  ��  ��         l     �� ! "��   ! #  notification flag with count    " � # # :   n o t i f i c a t i o n   f l a g   w i t h   c o u n t    $ % $ l    &���� & r     ' ( ' m    ����   ( o      ���� 0 lessnoticnt20 lessNoticnt20��  ��   %  ) * ) l    +���� + r     , - , m    ����   - o      ���� 0 lessnoticnt25 lessNoticnt25��  ��   *  . / . l    0���� 0 r     1 2 1 m    ����   2 o      ���� 0 lessnoticnt30 lessNoticnt30��  ��   /  3 4 3 l    5���� 5 r     6 7 6 m    ����   7 o      ���� 0 morenoticnt70 moreNoticnt70��  ��   4  8 9 8 l   ! :���� : r    ! ; < ; m    ����   < o      ���� 0 morenoticnt75 moreNoticnt75��  ��   9  = > = l  " % ?���� ? r   " % @ A @ m   " #����   A o      ���� 0 morenoticnt80 moreNoticnt80��  ��   >  B C B l     ��������  ��  ��   C  D E D l     �� F G��   F   notification process    G � H H *   n o t i f i c a t i o n   p r o c e s s E  I J I l  &� K���� K T   &� L L k   +� M M  N O N l  + +�� P Q��   P ) # get battery charging percent (70%)    Q � R R F   g e t   b a t t e r y   c h a r g i n g   p e r c e n t   ( 7 0 % ) O  S T S r   + 2 U V U I  + 0�� W��
�� .sysoexecTEXT���     TEXT W m   + , X X � Y Y � p m s e t   - g   b a t t   |   e g r e p   - o w   ' ( [ 0 - 9 ] { 1 , 3 } ) [ % ] '   |   e g r e p   - o w   ' [ 0 - 9 ] { 1 , 3 } '��   V o      ���� 0 percentleft percentLeft T  Z [ Z l  3 3�� \ ]��   \ "  Battery gage case algorithm    ] � ^ ^ 8   B a t t e r y   g a g e   c a s e   a l g o r i t h m [  _ ` _ P   3| a b�� a k   8{ c c  d e d l  8 8�� f g��   f R L Battery Uncharging case (Battery going down is made of 'uncharging status')    g � h h �   B a t t e r y   U n c h a r g i n g   c a s e   ( B a t t e r y   g o i n g   d o w n   i s   m a d e   o f   ' u n c h a r g i n g   s t a t u s ' ) e  i j i l  8 8�� k l��   k !  if percentge less than 20%    l � m m 6   i f   p e r c e n t g e   l e s s   t h a n   2 0 % j  n�� n Z   8{ o p q�� o F   8 G r s r B   8 = t u t o   8 9���� 0 percentleft percentLeft u m   9 <����  s B   @ C v w v o   @ A���� 0 lessnoticnt20 lessNoticnt20 w m   A B����  p k   J c x x  y z y r   J O { | { l  J M }���� } [   J M ~  ~ o   J K���� 0 lessnoticnt20 lessNoticnt20  m   K L���� ��  ��   | o      ���� 0 lessnoticnt20 lessNoticnt20 z  � � � I  P a�� � �
�� .sysonotfnull��� ��� TEXT � b   P Y � � � b   P U � � � m   P S � � � � � & B a t t e r y   2 0 %   l e s s .   ( � o   S T���� 0 lessnoticnt20 lessNoticnt20 � m   U X � � � � �  ) � �� ���
�� 
appr � m   Z ] � � � � � . B a t t e r y   C h a r g e   B o u n d a r y��   �  ��� � l  b b�� � ���   � !  if percentge less than 25%    � � � � 6   i f   p e r c e n t g e   l e s s   t h a n   2 5 %��   q  � � � F   f u � � � B   f k � � � o   f g���� 0 percentleft percentLeft � m   g j����  � B   n q � � � o   n o���� 0 lessnoticnt25 lessNoticnt25 � m   o p����  �  � � � k   x � � �  � � � r   x } � � � l  x { ����� � [   x { � � � o   x y���� 0 lessnoticnt25 lessNoticnt25 � m   y z���� ��  ��   � o      ���� 0 lessnoticnt25 lessNoticnt25 �  � � � I  ~ ��� � �
�� .sysonotfnull��� ��� TEXT � b   ~ � � � � b   ~ � � � � m   ~ � � � � � � & B a t t e r y   2 5 %   l e s s .   ( � o   � ����� 0 lessnoticnt25 lessNoticnt25 � m   � � � � � � �  ) � �� ���
�� 
appr � m   � � � � � � � . B a t t e r y   C h a r g e   B o u n d a r y��   �  ��� � l  � ��� � ���   � !  if percentge less than 30%    � � � � 6   i f   p e r c e n t g e   l e s s   t h a n   3 0 %��   �  � � � F   � � � � � B   � � � � � o   � ����� 0 percentleft percentLeft � m   � �����  � B   � � � � � o   � ����� 0 lessnoticnt30 lessNoticnt30 � m   � �����  �  � � � k   � � � �  � � � r   � � � � � l  � � ����� � [   � � � � � o   � ����� 0 lessnoticnt30 lessNoticnt30 � m   � ����� ��  ��   � o      ���� 0 lessnoticnt30 lessNoticnt30 �  � � � I  � ��� � �
�� .sysonotfnull��� ��� TEXT � b   � � � � � b   � � � � � m   � � � � � � � & B a t t e r y   3 0 %   l e s s .   ( � o   � ����� 0 lessnoticnt30 lessNoticnt30 � m   � � � � � � �  ) � �� ���
�� 
appr � m   � � � � � � � . B a t t e r y   C h a r g e   B o u n d a r y��   �  � � � l  � ��� � ���   � L F Battery Charging case (Battery going up is made of 'charging status')    � � � � �   B a t t e r y   C h a r g i n g   c a s e   ( B a t t e r y   g o i n g   u p   i s   m a d e   o f   ' c h a r g i n g   s t a t u s ' ) �  ��� � l  � ��� � ���   � !  if percentge more than 70%    � � � � 6   i f   p e r c e n t g e   m o r e   t h a n   7 0 %��   �  � � � F   � � � � � @   � � � � � o   � ����� 0 percentleft percentLeft � m   � ����� F � B   � � � � � o   � ����� 0 morenoticnt70 moreNoticnt70 � m   � �����  �  � � � k   � � � �  � � � r   � � � � � l  � � ����� � [   � � � � � o   � ����� 0 morenoticnt70 moreNoticnt70 � m   � ����� ��  ��   � o      ���� 0 morenoticnt70 moreNoticnt70 �  � � � I  � ��� � �
�� .sysonotfnull��� ��� TEXT � b   � � � � � b   � � � � � m   � � � � � � � & B a t t e r y   7 0 %   m o r e .   ( � o   � ����� 0 morenoticnt70 moreNoticnt70 � m   � � � � � � �  ) � �� ��
�� 
appr  m   � � � . B a t t e r y   C h a r g e   B o u n d a r y��   � �� l  � �����   !  if percentge more than 75%    � 6   i f   p e r c e n t g e   m o r e   t h a n   7 5 %��   �  F   � �	
	 @   � � o   � ����� 0 percentleft percentLeft m   � ����� K
 B   � � o   � ����� 0 morenoticnt75 moreNoticnt75 m   � �����   k    r   l ���� [   o  ���� 0 morenoticnt75 moreNoticnt75 m  ���� ��  ��   o      ���� 0 morenoticnt75 moreNoticnt75  I ��
�� .sysonotfnull��� ��� TEXT b   b    m  !! �"" & B a t t e r y   7 5 %   m o r e .   (  o  �� 0 morenoticnt75 moreNoticnt75 m  ## �$$  ) �~%�}
�~ 
appr% m  && �'' . B a t t e r y   C h a r g e   B o u n d a r y�}   (�|( l �{)*�{  ) !  if percentge more than 80%   * �++ 6   i f   p e r c e n t g e   m o r e   t h a n   8 0 %�|   ,-, F  -./. @  #010 o  �z�z 0 percentleft percentLeft1 m  "�y�y P/ B  &)232 o  &'�x�x 0 morenoticnt80 moreNoticnt803 m  '(�w�w - 454 k  0I66 787 r  059:9 l 03;�v�u; [  03<=< o  01�t�t 0 morenoticnt80 moreNoticnt80= m  12�s�s �v  �u  : o      �r�r 0 morenoticnt80 moreNoticnt808 >?> I 6G�q@A
�q .sysonotfnull��� ��� TEXT@ b  6?BCB b  6;DED m  69FF �GG & B a t t e r y   8 0 %   m o r e .   (E o  9:�p�p 0 morenoticnt80 moreNoticnt80C m  ;>HH �II  )A �oJ�n
�o 
apprJ m  @CKK �LL . B a t t e r y   C h a r g e   B o u n d a r y�n  ? M�mM l HH�lNO�l  N   init notification count   O �PP 0   i n i t   n o t i f i c a t i o n   c o u n t�m  5 QRQ F  L]STS A  LQUVU m  LO�k�k V o  OP�j�j 0 percentleft percentLeftT A  TYWXW o  TU�i�i 0 percentleft percentLeftX m  UX�h�h FR Y�gY k  `wZZ [\[ r  `c]^] m  `a�f�f  ^ o      �e�e 0 lessnoticnt20 lessNoticnt20\ _`_ r  dgaba m  de�d�d  b o      �c�c 0 lessnoticnt25 lessNoticnt25` cdc r  hkefe m  hi�b�b  f o      �a�a 0 lessnoticnt30 lessNoticnt30d ghg r  loiji m  lm�`�`  j o      �_�_ 0 morenoticnt70 moreNoticnt70h klk r  psmnm m  pq�^�^  n o      �]�] 0 morenoticnt75 moreNoticnt75l o�\o r  twpqp m  tu�[�[  q o      �Z�Z 0 morenoticnt80 moreNoticnt80�\  �g  ��  ��   b �Y�X
�Y consnume�X  ��   ` r�Wr I }��Vs�U
�V .sysodelanull��� ��� nmbrs m  }��T�T 
�U  �W  ��  ��   J tut l     �S�R�Q�S  �R  �Q  u vwv l     �P�O�N�P  �O  �N  w xyx l     �Mz{�M  z   original code   { �||    o r i g i n a l   c o d ey }~} l     �L��L     repeat   � ���    r e p e a t~ ��� l     �K���K  � d ^ 	set chargeState to do shell script "pmset -g batt | awk '{printf \"%s %s\\n\", $4,$5;exit}'"   � ��� �   	 s e t   c h a r g e S t a t e   t o   d o   s h e l l   s c r i p t   " p m s e t   - g   b a t t   |   a w k   ' { p r i n t f   \ " % s   % s \ \ n \ " ,   $ 4 , $ 5 ; e x i t } ' "� ��� l     �J���J  � q k 	set percentLeft to do shell script "pmset -g batt | egrep -ow '([0-9]{1,3})[%]' | egrep -ow '[0-9]{1,3}'"   � ��� �   	 s e t   p e r c e n t L e f t   t o   d o   s h e l l   s c r i p t   " p m s e t   - g   b a t t   |   e g r e p   - o w   ' ( [ 0 - 9 ] { 1 , 3 } ) [ % ] '   |   e g r e p   - o w   ' [ 0 - 9 ] { 1 , 3 } ' "� ��� l     �I���I  � #  	considering numeric strings   � ��� :   	 c o n s i d e r i n g   n u m e r i c   s t r i n g s� ��� l     �H���H  � Y S 		if chargeState contains "Battery Power" or "AC Power" and percentLeft �� 30 then   � ��� �   	 	 i f   c h a r g e S t a t e   c o n t a i n s   " B a t t e r y   P o w e r "   o r   " A C   P o w e r "   a n d   p e r c e n t L e f t  "d   3 0   t h e n� ��� l     �G���G  � j d 			display notification "Battery 30% less (REQUIRES CHARGING)" with title "Battery Charge Boundary"   � ��� �   	 	 	 d i s p l a y   n o t i f i c a t i o n   " B a t t e r y   3 0 %   l e s s   ( R E Q U I R E S   C H A R G I N G ) "   w i t h   t i t l e   " B a t t e r y   C h a r g e   B o u n d a r y "� ��� l     �F���F  � ^ X 		else if chargeState contains "Battery Power" or "AC Power" and percentLeft �� 70 then   � ��� �   	 	 e l s e   i f   c h a r g e S t a t e   c o n t a i n s   " B a t t e r y   P o w e r "   o r   " A C   P o w e r "   a n d   p e r c e n t L e f t  "e   7 0   t h e n� ��� l     �E���E  � d ^ 			display notification "Battery 70% more (NO CHARGING)" with title "Battery Charge Boundary"   � ��� �   	 	 	 d i s p l a y   n o t i f i c a t i o n   " B a t t e r y   7 0 %   m o r e   ( N O   C H A R G I N G ) "   w i t h   t i t l e   " B a t t e r y   C h a r g e   B o u n d a r y "� ��� l     �D���D  �  	 		end if   � ���    	 	 e n d   i f� ��� l     �C���C  �   	end considering   � ��� "   	 e n d   c o n s i d e r i n g� ��� l     �B���B  �  
 	delay 60   � ���    	 d e l a y   6 0� ��A� l     �@���@  �   end repeat   � ���    e n d   r e p e a t�A       �?���?  � �>
�> .aevtoappnull  �   � ****� �=��<�;���:
�= .aevtoappnull  �   � ****� k    ���  ��  ��  $��  )��  .��  3��  8��  =��  I�9�9  �<  �;  �  � * �8 �7�6�5�4�3�2�1�0�/ X�.�- b�,�+ � � ��* � � ��) � � ��( � ��'!#&�&FHK�%
�8 
appr
�7 .sysonotfnull��� ��� TEXT�6 
�5 .sysodelanull��� ��� nmbr�4 0 lessnoticnt20 lessNoticnt20�3 0 lessnoticnt25 lessNoticnt25�2 0 lessnoticnt30 lessNoticnt30�1 0 morenoticnt70 moreNoticnt70�0 0 morenoticnt75 moreNoticnt75�/ 0 morenoticnt80 moreNoticnt80
�. .sysoexecTEXT���     TEXT�- 0 percentleft percentLeft�, 
�+ 
bool�* �) �( F�' K�& P�% 
�:����l O�j OjE�OjE�OjE�OjE�OjE�OjE�ObhZ�j E�O�gF�a 	 	�la & �kE�Oa �%a %�a l OPY�a 	 	�la & �kE�Oa �%a %�a l OPY ��a 	 	�la & �kE�Oa �%a %�a l OPY ��a 	 	�la & �kE�Oa �%a %�a  l OPY ��a !	 	�la & �kE�Oa "�%a #%�a $l OPY _�a %	 	�la & �kE�Oa &�%a '%�a (l OPY 1a �	 �a a & jE�OjE�OjE�OjE�OjE�OjE�Y hVOa )j [OY��ascr  ��ޭ