<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <Style>
        .header{
            height: 70px;
            display: flex;
            background-color: aqua;
            justify-content: space-evenly;
            align-items: center;
        }
        .main{
            
            height: 650px;
            background-image: url("im1.jpg");
            background-size: cover;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .blank{
            height: 500px;
            width: 850px;
        }
        .inquiry{
            /* border: 2px solid black; */
            height: 500px;
            width: 400px;
            background-color: aqua;
        }
        .name{
            background-color: white;
            width: 350px;
            height: 25px;
            padding-left: 5px;
            margin-bottom: 20px;
            margin-top: 10px;
        }
        .name1{
            background-color: white;
            width: 350px;
            height: 50px;
            padding-left: 5px;
            margin-bottom: 20px;
            margin-top: 10px;
        }
        form{
            margin-left: 10px;
            margin-top: 15px;
        }
        .butt{
            display: flex;
            justify-content: center;
        }
        .but{
            width: 100px;
            height: 50px;
            margin: auto;
            /* margin-top: 50px; */
        }
        #area{
            height: 30px;
        }
    </Style>
</head>
<body>
    <div class="header">
        <div>Home</div>
        <div>About</div>
        <div><a href="teacherlogin.html">Teacher Login</a></div>
        <div><a href="login.html">Student Login</a></div>
        <div><a href="managelogin.html">Management Login</a></div>
    </div>
    <div class="main">
        <div class="blank">

        </div>
        <div class="inquiry">
            <form action="submit">
                <label for="name">Name</label>
                <input type="text" placeholder="Enter your Name" class="name">
                <label for="Contact">Contact Number</label>
                <input type="text" placeholder="Enter Contact Number" class="name">
                <label for="Contact">Highest Education</label>
                <input type="text" placeholder="Enter Highest Education" class="name">
                <label for="Contact">Inquiry For Which Class</label>
                <input type="text" placeholder="Enter Inquiry Class" class="name">
                <label for="Contact">Message</label>
                <textarea name="" id="" cols="30" rows="5" class="name1" id="area"></textarea>
                <div class="butt"><button class="but">Submit</button></div>
            </form>
        </div>
    </div>
</body>
</html>