# Future-Gadget-Labs-HINT

## Meishu: A Drone Based Rescue System
Disaster refers to a widespread severe disruption of the social, economic and environmental resources of a community which affects every sphere of life equally, be it a rich man or a poor man, or even animals. The major causes which causes distress once a disaster has occurred is lack of information and loss of information conveying capability in such cases. In the proposed idea, we aid the rescuing process multifold. In cases of floods and other water related calamities, it is the safest practice to find the highest ground possible to stay away from water and prevent you from drowning. In cases of calamities like earthquakes which scatters the mass and makes it harder and much more expensive for the rescuing teams to find individuals who are stuck for appropriate directions, a common and often higher planar ground for easy identification is desirable. Hence, we propose a solution which uses drones to 3D map the whole disaster stricken area, map the points according to their height, and deliver this, along with any other crucial information to the user smartphones using a developed app which offers a fast and reliable point-to-point communication protocol to get connected to the drones already in the process of 3D mapping, and receives crucial information to the user. Further, the communication is made two way where a user, along with their localized position in the 3D map, could give a distress message for stuck-immobile people using the connection itself by pushing a simple button. This solution aims to solve the problem of gathering valuable data in a precise and efficient way using drones and also the problem of lack of communication link, by making a short ranged P2P communication link with devices that is possessed by a very large portion of the population, i.e., mobile to drone communication, all while making the . The saved information are then relayed to the rescue team to pinpoint the rescue operation and localized map the whole area. The name Meishu means a leading power in Japanese which symbolizes the navigating functionality of the drones to find the apex.

<img src="https://github.com/DivyanshMalhotra/Future-Gadget-Labs-HINT/blob/master/Flowchart%20Meishu.png" align="centre">


### Key Features
1. The mobile to drone communication relies on LAN, hence no external network is needed. We aim to use NodeMCU for the communication part with an android application on the smartphone. Therefore, there is no dependance of the drone or the user mobile phones to any other external factor, signals from towers, satellite signals, etc. 
2. A very large area can be scanned by the drone in short amounts of time using efficient utilization of resources, cheap add-ons and automated navigation using reliability to only GPS coordinates (Satellite inferencing). 
Communication to people and a channel of interaction can be formed where human rescue otherwise is either delayed, or not possible to be present in every nook.
3. Highest ground and a safe area is notified using a localized map which helps the rescuing operation significantly.
Immobilized crowd can be found out by the rescuing teams by nearby mobile people or immobile people having the access of a smartphone

<img src="https://github.com/DivyanshMalhotra/Future-Gadget-Labs-HINT/blob/master/Meishu.png">


###System Description

The system consists of three main parts
#### 1. Aerial Part- 
This includes drone(s) which will be used to navigate through the area in an unmanned fashion. The drone is guided by the GPS coordinates which are generally unaltered due to their direct dependence on the satellite systems and the high altitude of the drone which allows unobstructed detection. This part is responsible for covering the whole area to map it as well as provide a P2P connection at brief time intervals for people to connect. Any type of drones can be utilized with the only parameter being a good enough battery life and carrying capability for 
    1.1 A system for P2P communication with individual mobile phones.
    1.2 A system for communication with the base station through antenna transmission or a storage unit which could store the information retrieved by the drone to be delivered on return to its launch position,
    1.3A 3D mapping camera/LIDAR sensors/monocular camera with a good processor to use advance deep learning techniques
#### 2.3D Mapping Part-
This part can be done using a stereo camera for capturing the Depth information or using a LIDAR sensor. This capturing process needs to be synchronized with the GPS positioning of points of capture. Hence, we need to capture the whole area using Simultaneous Localization (which is done by recording position points of capturing) And Mapping. 
A relatively newer method is the use of a monocular camera along with deep learning to make a depth map of the captured area, This method is relatively cheaper to implement on each drone, however even the state of the art results in the technology does not offer promising results. 
#### 3. P2P Communication Part-
This part underlies the point to point communication with each phone in its range, which is close to 100m. The communication can be done by making a LAN in which the drone provides a open to connect network or using Bluetooth (not recommended due to single pairing at a time and slow data transfer rate due to a more secure protocol which does not concern the situation at hand). The users need to open a developed application on the phone which looks for such open connectivity points and connects to them as soon as one is detected within range. From the network, the application fetches the important data to proceed towards the localized highest point in the vicinity according to his current localized position according to the current drone position and the safest path to reach there. The application will also allow an SOS button for distress calls which forms the other end of communication to the drone, which in turn delivers this data to its base station (the nearest safe point) and thus helps significantly in the rescue operation.
