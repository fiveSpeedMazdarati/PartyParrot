<html>
<head>
    <link rel="shortcut icon" type="image/icon" href="favicon.ico">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/main.css">
<title>Party Parrot 4 Ever</title>
</head>
<body>
<div class="container">
    <div class="container-fluid">
    <div class="fixed-top">
        <img src="parrotbanner.jpg" alt="banner" style="width: 100%">
    </div>
    </div>
</div>
<div class="container tm">

    <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="https://cultofthepartyparrot.com" target="_blank">
                        Party Parrots
                    </a>
                </li>
                <li>
                    <a href="#name">Find By Name</a>
                </li>
                <li>
                    <a href="#category">Find By Category</a>
                </li>
                <li>
                    <a href="#categories">Get List of Categories</a>
                </li>
                <li>
                    <a href="#all">Get All Parrots</a>
                </li>
                <li>
                    <a href="#add">Add A Parrot</a>
                </li>
                <li>
                    <a href="#donate">Donate</a>
                </li>

            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
<%--
                <div class="row">
--%>
                    <div class="col-md-12">
                        <h3>The Preeminent Party Parrot API on the ENTIRE internets!</h3>

                    </div>
                <br/><br/>
                <h3>Method URLs</h3>
    <p>Base: <a href="http://52.14.41.110:8080/PartyParrot4Ever/services/parrots">http://52.14.41.110:8080/PartyParrot4Ever/services/parrots</a></p>

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Method</th>
                        <th>Endpoint</th>
                        <th>Description</th>
                    </thead>
                    <tr>
                        <td>Get Parrot by entering Parrot's name
                        </td>
                        <td>/parrot/(parrot name)
                        </td>
                        <td>Accepts name as input and returns attributes for the matched parrot
                        </td>
                    </tr>
                    <tr>
                        <td>Get Parrots by entering Parrot category
                        </td>
                        <td>/category/(category name)
                        </td>
                        <td>Accepts a category and returns all parrots data in that category
                        </td>
                    </tr>

                    <tr>
                        <td>Get List of Parrot Categories
                        </td>
                        <td>/categories
                        </td>
                        <td>Returns all categories Party Parrots may fall into
                        </td>
                    </tr>

                    <tr>
                        <td class="mr-2">Get All the Parrots
                        </td>
                        <td>(the base url will take you there!)
                        </td>
                        <td>Returns all Parrots ... because why not?
                        </td>
                    </tr>

                    <tr>
                        <td>Add a Parrot
                        </td>
                        <td>/parrots/(name)/(link)/(hd link)/(category)
                        </td>
                        <td>Contributes to the ever-growing Party Parrot enterprise
                        </td>
                    </tr>


                </table>

                <section class="mt-5" id="name">
                    <h3>Get Parrot By Name</h3>
                    <p>Example Request: /Aussie Parrot<small class="pl-2">(Spaces are okay!! We handle that)</small></p>
                    <div class="card">
                        <div class="card-body">
                            <code> <br/>
                                <span class="pl-2"> {</span>
                                    <br/>
                                    <span class="pl-4">"gif": <a href="https://cultofthepartyparrot.com/parrots/aussieparrot.gif">"https://cultofthepartyparrot.com/parrots/aussieparrot.gif"</a>,</span><br/>
                                <span class="pl-4">"name": "Aussie Parrot",</span><br/>
                                <span class="pl-4">"hd": <a href="https://cultofthepartyparrot.com/parrots/hd/aussieparrot.gif">"https://cultofthepartyparrot.com/parrots/hd/aussieparrot.gif"</a>,</span><br/>
                                    <span class="pl-4">"category": "traditional"</span><br/>
                                    <span class="pl-2">}<br/></span>
                                </code>
                        </div>
                    </div>
                </section>

    <section class="mt-5" id="category">
        <h3>Get Parrot By Category</h3>
        <p>Example Request: /technology</p>
        <div class="card">
            <div class="card-body">
                <code> <br/>
                    [<br/>
                    <span class="pl-2"> {</span>
                    <br/>
                    <span class="pl-4">"gif": <a href="https://cultofthepartyparrot.com/parrots/opensourceparrot.gif">"https://cultofthepartyparrot.com/parrots/opensourceparrot.gif"</a>,</span><br/>
                    <span class="pl-4">"name": "Open-source Parrot",</span><br/>
                    <span class="pl-4">"hd": <a href="https://cultofthepartyparrot.com/parrots/hd/opensourceparrot.gif">"https://cultofthepartyparrot.com/parrots/hd/opensourceparrot.gif"</a>,</span><br/>
                    <span class="pl-4">"category": "technology"</span><br/>
                    <span class="pl-2">},<br/></span>
                    <span class="pl-2"> {</span>
                    <br/>
                    <span class="pl-4">"gif": null, </span><br/>
                    <span class="pl-4">"name": "Github Party Parrot",</span><br/>
                    <span class="pl-4">"hd": <a href="https://cultofthepartyparrot.com/parrots/hd/githubparrot.gif">"https://cultofthepartyparrot.com/parrots/hd/githubparrot.gif"</a>,</span><br/>
                    <span class="pl-4">"category": "technology"</span><br/>
                    <span class="pl-2">},<br/></span>
                    <span class="pl-2"> {</span><br/>
                    <span class="pl-4">"gif": <a href="https://cultofthepartyparrot.com/parrots/upvoteparrot.gif">"https://cultofthepartyparrot.com/parrots/upvoteparrot.gif",</a></span><br/>
                    <span class="pl-4">"name": "Upvote Parrot",</span><br/>
                    <span class="pl-4">"hd": null,</span><br/>
                    <span class="pl-4">"category": "technology"</span><br/>
                    <span class="pl-2">}<br/></span>
                ]
                </code>
            </div>
        </div>
    </section>

    <section class="mt-5" id="categories">
        <h3>Get Possible Parrot Categories</h3>
        <p>Request: /categories</p>
        <div class="card">
            <div class="card-body">
                <code> <br/>
                    [<br/>
                    <span class="pl-4">"traditional",</span><br/>
                    <span class="pl-4">"technology",</span><br/>
                     <span class="pl-4">"hip",</span><br/>
                     <span class="pl-4">"food",</span><br/>
                     <span class="pl-4">"holiday",</span><br/>
                     <span class="pl-4">"steve",</span><br/>
                     <span class="pl-4">"bernardo",</span><br/>
                     ]
                </code>
            </div>
        </div>
    </section>


    <section class="mt-5" id="all">
        <h3>Get All Parrots!</h3>
        <p>Request: /parrots</p>
        <div class="card">
            <div class="card-body">
                <code> <br/>
                    [<br/>
                    <span class="pl-2"> {</span>
                    <br/>
                    <span class="pl-4">"gif": <a href="https://cultofthepartyparrot.com/parrots/parrot.gif">"https://cultofthepartyparrot.com/parrots/parrot.gif",</a></span><br/>
                    <span class="pl-4">"name": "Parrot",</span><br/>
                    <span class="pl-4">"hd": <a href="https://cultofthepartyparrot.com/parrots/hd/parrot.gif">"https://cultofthepartyparrot.com/parrots/hd/parrot.gif"</a>,</span><br/>
                    <span class="pl-4">"category": "traditional"</span><br/>
                    <span class="pl-2">},<br/></span>

                    <span class="pl-2"> {</span>
                    <br/>
                    <span class="pl-4">"gif": <a href="https://cultofthepartyparrot.com/parrots/opensourceparrot.gif">"https://cultofthepartyparrot.com/parrots/opensourceparrot.gif"</a>,</span><br/>
                    <span class="pl-4">"name": "Open-source Parrot",</span><br/>
                    <span class="pl-4">"hd": <a href="https://cultofthepartyparrot.com/parrots/hd/opensourceparrot.gif">"https://cultofthepartyparrot.com/parrots/hd/opensourceparrot.gif"</a>,</span><br/>
                    <span class="pl-4">"category": "technology"</span><br/>
                    <span class="pl-2">},<br/></span>
                    <span class="pl-2"> {</span>
                    <br/>
                    <span class="pl-4">"gif": <a href="https://cultofthepartyparrot.com/parrots/middleparrot.gif">"https://cultofthepartyparrot.com/parrots/middleparrot.gif",</a>,</span><br/>
                    <span class="pl-4">"name": "Middle Parrot",</span><br/>
                    <span class="pl-4">"hd": <a href="https://cultofthepartyparrot.com/parrots/hd/middleparrot.gif">"https://cultofthepartyparrot.com/parrots/hd/middleparrot.gif"</a>,</span><br/>
                    <span class="pl-4">"category": "traditional"</span><br/>
                    <span class="pl-2">},<br/></span>
                    <span class="pl-4">"gif": <a href="https://cultofthepartyparrot.com/parrots/aussieparrot.gif">"https://cultofthepartyparrot.com/parrots/aussieparrot.gif"</a>,</span><br/>
                    <span class="pl-4">"name": "Aussie Parrot",</span><br/>
                    <span class="pl-4">"hd": <a href="https://cultofthepartyparrot.com/parrots/hd/aussieparrot.gif">"https://cultofthepartyparrot.com/parrots/hd/aussieparrot.gif"</a>,</span><br/>
                    <span class="pl-4">"category": "traditional"</span><br/>
                    <span class="pl-2">}<br/></span>
                    ] </code> <br/>+ 140 more and counting!!

            </div>
        </div>
    </section>
              <%--  </div>--%>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

        <section class="mt-5" id="add">
            <h3>Add a Parrot!</h3>
            <p>Example Request: /Doge<br/>
                <span class="ml-5">  /https://cultofthepartyparrot.com/guests/hd/dogeparrot.gif</span><br/>
                <span class="ml-5">  /https://cultofthepartyparrot.com/guests/hd/dogeparrot.gif</span><br/>
                <span class="ml-5">  /guests</span><br/>

            <p>Or use this handy form!</p>
            <div class="card text-white bg-dark col-sm-6 mt-3">
            <div class="card-body">
            <form enctype="application/x-www-form-urlencoded" action="http://52.14.41.110:8080/PartyParrot4Ever/services/parrots/parrots/" method="POST">
            <div class="form-group">
                <label class="mr-3">Name: </label><input name="name"/><br />
            </div>
            <div class="form-group">
                <label class="mr-3">Link: </label><input name="link"><br />
            </div>
            <div class="form-group">
                <label class="mr-3">HD Link:</label><input name="hdLink"><br />
            </div>
            <div class="form-group">
                <label class="mr-3">Category:</label><input name="category"><br />
            </div>
                <span class="float-right">
                <input type="submit" value="Add Parrot" class="btn btn-outline-info">
                </span>
            </form>
            </div>
        </div>

        </section>
<br/><br/>
        <section id="donate mt-5">

            <h3>Donate to keep the Parrots Partying!</h3>
            <br/>
           <a href="https://www.doc.govt.nz/kakapo-recovery">Donate Here</a>
        <br/>
        </section>
<br/><br/>
    <!-- /#wrapper -->
<footer class="col-sm-6 offset-3">&copy;2019 Party Parrot 4 Ever - Heidi, Luke, Kelly</footer
    <br/><br/>
</div>
</div>
</body>

</html>
