/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file illustrates the concept of driving a path based on time.
 * It uses the common Pushbot hardware class to define the drive on the robot.
 * The code is structured as a LinearOpMode
 *
 * The code assumes that you do NOT have encoders on the wheels,
 *   otherwise you would use: PushbotAutoDriveByEncoder;
 *
 *   The desired path in this example is:
 *   - Drive forward for 3 seconds
 *   - Spin right for 1.3 seconds
 *   - Drive Backwards for 1 Second
 *   - Stop and close the claw.
 *
 *  The code is written in a simple form with no optimizations.
 *  However, there are several ways that this type of sequence could be streamlined,
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="Autonomous0", group="Pushbot")
public class Autonomous0 extends LinearOpMode {

    /* Declare OpMode members. */
    Hardware_20_21 robot = new Hardware_20_21(); // use the class created to define a robot's hardware
    private ElapsedTime     runtime = new ElapsedTime();



    static final double     FORWARD_SPEED = 0.6;
    static final double     TURN_SPEED    = 0.5;

    @Override
    public void runOpMode() {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */

        // Send telemetry message to signify robot waiting;



        robot.init(hardwareMap, this);

        robot.frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rearLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rearRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.intakemotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.launcher1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.launcher2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rearLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rearRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.intakemotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.launcher1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.launcher2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        //  going strat is - and turning is counterclockwise
        //------------------------------------------------------------------------------------------
        //STEP 1
        // Drive to the ring and shot

        robot.wobblehand.setPosition(0.35);
        robot.drivestraightsonicsensor(-55,0.3,19);

        robot.launcher1.setPower(0.75);
        robot.launcher2.setPower(0.9);
        sleep(1100);

        robot.launcher1.setPower(0.75);
        robot.launcher2.setPower(0.9);

        robot.conveyor.setPower(1);

        robot.forks.setPosition(0.22);
        sleep(250);

        robot.kicker.setPosition(0.6);
        sleep(250);

        robot.kicker.setPosition(1);
        sleep(50);

        robot.conveyor.setPower(1);
        sleep(750);

        robot.forks.setPosition(0.27);
        sleep(350);

        robot.kicker.setPosition(0.6);
        sleep(50);

        robot.conveyor.setPower(1);
        sleep(1300);


        robot.launcher1.setPower(0);
        robot.launcher2.setPower(0);
        robot.conveyor.setPower(0);
        //------------------------------------------------------------------------------------------
        //STEP 2
        // Drive turn and drop the wobble
        //robot.drivestraight(-70,0.4);
        robot.drivestraightsonicsensor(-36,0.3,19);

        robot.trunangel(86,0.3);

        robot.drivestraightsonicsensor(19,0.3,32.3);

        robot.robotsleep(0);
        sleep(100);
        robot.wobble.setPosition(0.25);
        sleep(1500);

        robot.wobblehand.setPosition(1);
        //------------------------------------------------
        //STEP 3
        // Get next wobble
        robot.drivestraightsonicsensor(-23.5,0.3,32.3);

        robot.trunangel(-82,0.3);

        robot.drivestraightsonicsensor(96,0.4,22);

        robot.robotsleep(0);
        sleep(500  );
        robot.wobblehand.setPosition(0.35);
        sleep(500);

        robot.wobble.setPosition(1);
        //------------------------------------------------------------------------------------------
        //STEP 4
        //Drive turn and drop the wobble
        robot.drivestraightsonicsensor(-92,0.4,22);

        robot.trunangel(85,0.3);

        robot.drivestraightsonicsensor(10,0.3,39.5);

        robot.wobble.setPosition(0.25);
        sleep(1250);

        robot.wobblehand.setPosition(1);
        sleep(500);

        robot.wobble.setPosition(1);
        //------------------------------------------------------------------------------------------
        //STEP 5
        // Park
        robot.drivestraight(-20,1);

        robot.trunangel(-50,1);

        robot.drivestraight(22  ,1);


        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Vertical left encoder position", robot.frontRightMotor.getCurrentPosition());
        telemetry.addData("Vertical right encoder position", robot.rearLeftMotor.getCurrentPosition());
        telemetry.addData("horizontal encoder position", robot.rearRightMotor.getCurrentPosition());
        telemetry.addData("intake", " %d", robot.intakemotor.getCurrentPosition());
        telemetry.addData("launcher1", " %.0f",robot.launcher1.getVelocity()/28*60);
        telemetry.addData("launcher2", "%.0f",robot.launcher2.getVelocity()/28*60);
        telemetry.update();

    }
}
